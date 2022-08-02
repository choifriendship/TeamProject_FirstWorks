package com.groupware.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.groupware.dto.Apv_vc_dto;
import com.groupware.service.ApprovalService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class ApprovalController {
	@Autowired
	ApprovalService service;

	@InitBinder
	public void initbinder(WebDataBinder binder) {
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(d, false));
	}

//  LEVEL1의 결재대기문서 숫자
//  LEVEL2의 결재대기문서 숫자
//  LEVEL3의 결재대기문서 숫자
	@GetMapping("/")
	public String test(HttpSession session, Model m) {
		if (session.getAttribute("mem_no") != null) {
			m.addAttribute("mem_no", (Integer) session.getAttribute("mem_no"));
			m.addAttribute("rank_no", (Integer) session.getAttribute("rank_no"));
			if ((Integer) session.getAttribute("rank_no") == 1) {
				m.addAttribute("count", service.waitcnt((Integer) session.getAttribute("mem_no")));
			} else if ((Integer) session.getAttribute("rank_no") == 2) {
				m.addAttribute("count", service.waitcnt1((Integer) session.getAttribute("mem_no")));
			} else {
				m.addAttribute("count", service.waitcnt2((Integer) session.getAttribute("mem_no")));
			}
		}
		return "home";
	}

//	휴가신청서 작성 폼 (주임, 대리)
	@GetMapping("/Apv_vc_form")
	public String Apv_vc_form() {
		return "Apv_vc_form";
	}

//	휴가신청서 작성 폼 (부장, 팀장)
	@GetMapping("/Apv_vc_form1")
	public String Apv_vc_form1() {
		return "Apv_vc_form1";
	}

//	휴가신청서 작성 폼 (실장, 임원, 사장)
	@GetMapping("/Apv_vc_form2")
	public String Apv_vc_form2() {
		return "Apv_vc_form2";
	}

//	휴가신청서 입력하기 (휴가신청서 테이블, 전자결재 테이블, 결재대기함 동시에 입력)
	@PostMapping("/Apv_vc_pro")
	public String Apv_vc_pro(Apv_vc_dto vc, HttpSession session) {
		service.apv_vc_insert(vc, session);
		return "redirect:/";
	}

//	중간결재자가 휴가신청 할때 휴가본문작성문
	@PostMapping("/Apv_vc_pro1")
	public String Apv_vc_pro1(Apv_vc_dto vc, HttpSession session) {
		service.apv_vc_insert1(vc, session);
		return "redirect:/";
	}

//  최종결재자가 휴가신청할때 휴가본문테이블에 생성함
	@PostMapping("/Apv_vc_pro2")
	public String Apv_vc_pro2(Apv_vc_dto vc, HttpSession session) {
		service.apv_vc_insert2(vc, session);
		return "redirect:/";
	}

//	대기테이블 첫번째, 두번째, 세번째
	@GetMapping("/Apv_wait_list")
	public String Apv_wait_list(HttpSession session, Model m) {
		if ((Integer) session.getAttribute("rank_no") == 1) {
			m.addAttribute("list", service.waitlist(session));
			m.addAttribute("rank_no", (Integer) session.getAttribute("rank_no"));
		} else if ((Integer) session.getAttribute("rank_no") == 2) {
			m.addAttribute("list", service.waitlist1(session));
			m.addAttribute("rank_no", (Integer) session.getAttribute("rank_no"));
		} else {
			m.addAttribute("list", service.waitlist2(session));
			m.addAttribute("rank_no", (Integer) session.getAttribute("rank_no"));
		}
		return "/Apv_wait_list";
	}

//	대기테이블에서 휴가 상세보기 가져오기
	@GetMapping("/Apv_wait_list_detail")
	public String Apv_wait_list_detail(int apv_no, Model m, HttpSession session) {
		m.addAttribute("rank_no", (Integer) session.getAttribute("rank_no"));
		m.addAttribute("mem_no", (Integer) session.getAttribute("mem_no"));
		m.addAttribute("list", service.Apv_wait_list_detail(apv_no));
		return "/Apv_wait_list_detail";
	}

//	대기테이블에 중간결재자 업데이트
//	휴가테이블에 중간결재자 업데이트(휴가 본문에 도장 업데이트문)
	@PostMapping("/midcf")
	public String midcf(HttpSession session, int apv_no) {
		service.midcf(session, apv_no);
		return "redirect:/Apv_wait_list";
	}

//	대기테이블에 최종결재자 업데이트(승인테이블에 승인란(cf)에 1로 업데이트)
//	휴가테이블에 최종결재자 업데이트(휴가본문에 도장 업데이트문)
//	최종결재자 결재완료 승인테이블에 승인확인란(cf)에 1을 넣어서 승인완료처리 (0은 결재대기)
//	대기테이블에서 삭제(완료테이블로 가기 위해)
	@PostMapping("/fnlcf")
	public String threecf(HttpSession session, int apv_no) {
		service.fnlcf(session, apv_no);
		return "redirect:/Apv_wait_list";
	}

//	결재완료된것들 리스트 페이지 불러오기(자기가 결재한 문서들만)
	@GetMapping("/cflist")
	public String cflist(HttpSession session, Model m) {
		m.addAttribute("list", service.cflist(session));
		return "cflist";
	}

//	결재완료된것들 리스트 전체 불러오기
	@GetMapping("/cflistall")
	public String cflistall(Model m) {
		m.addAttribute("list", service.cflistall());
		return "cflistall";
	}

//	결재완료된것들 리스트 상세 불러오기
	@GetMapping("/cfdetail")
	public String cfdetail(int apv_no, Model m) {
		m.addAttribute("list", service.cf_list_detail(apv_no));
		return "cfdetail";
	}

//	반려처리함 리스트 페이지 불러오기
	@GetMapping("/rjt")
	public String rjt(Apv_vc_dto vc) {
		service.rjt(vc);
		return "redirect:/watinglist";
	}

//	반려처리함 리스트 전체 불러오기
	@GetMapping("/rjtlist")
	public String rejlist(HttpSession session, Model m) {
		m.addAttribute("list", service.rjtlist(session));
		return "rjtlist";
	}

//	반려처리함 리스트 상세 불러오기
	@GetMapping("/rjtdetail")
	public String rejdetail(int apv_no, Model m) {
		m.addAttribute("list", service.rjtdetail(apv_no));
		return "/rjtdetail";
	}

}
