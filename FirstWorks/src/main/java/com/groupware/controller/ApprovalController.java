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
				m.addAttribute("count", service.apv_wait_cnt((Integer) session.getAttribute("mem_no")));
			} else if ((Integer) session.getAttribute("rank_no") == 2) {
				m.addAttribute("count", service.apv_wait_cnt1((Integer) session.getAttribute("mem_no")));
			} else {
				m.addAttribute("count", service.apv_wait_cnt2((Integer) session.getAttribute("mem_no")));
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
			m.addAttribute("list", service.apv_wait_list(session));
			m.addAttribute("rank_no", (Integer) session.getAttribute("rank_no"));
		} else if ((Integer) session.getAttribute("rank_no") == 2) {
			m.addAttribute("list", service.apv_wait_list1(session));
			m.addAttribute("rank_no", (Integer) session.getAttribute("rank_no"));
		} else {
			m.addAttribute("list", service.apv_wait_list2(session));
			m.addAttribute("rank_no", (Integer) session.getAttribute("rank_no"));
		}
		return "/Apv_wait_list";
	}

//	대기테이블에서 휴가 상세보기 가져오기
	@GetMapping("/Apv_wait_detail")
	public String Apv_wait_detail(int apv_no, Model m, HttpSession session) {
		m.addAttribute("rank_no", (Integer) session.getAttribute("rank_no"));
		m.addAttribute("mem_no", (Integer) session.getAttribute("mem_no"));
		m.addAttribute("list", service.apv_wait_detail(apv_no));
		return "/Apv_wait_list_detail";
	}

//	대기테이블에 중간결재자 업데이트
//	휴가테이블에 중간결재자 업데이트(휴가 본문에 도장 업데이트문)
	@PostMapping("/Apv_update1")
	public String midcf(HttpSession session, int apv_no) {
		service.apv_update1(session, apv_no);
		return "redirect:/Apv_wait_list";
	}

//	대기테이블에 최종결재자 업데이트(승인테이블에 승인란(cf)에 1로 업데이트)
//	휴가테이블에 최종결재자 업데이트(휴가본문에 도장 업데이트문)
//	최종결재자 결재완료 승인테이블에 승인확인란(cf)에 1을 넣어서 승인완료처리 (0은 결재대기)
//	대기테이블에서 삭제(완료테이블로 가기 위해)
	@PostMapping("/Apv_update2")
	public String threecf(HttpSession session, int apv_no) {
		service.apv_update2(session, apv_no);
		return "redirect:/Apv_wait_list";
	}

//	결재완료된것들 리스트 페이지 불러오기(자기가 결재한 문서들만)
	@GetMapping("/Apv_cf_list")
	public String cflist(HttpSession session, Model m) {
		m.addAttribute("list", service.apv_cf_list(session));
		return "Apv_cf_list";
	}

//	결재완료된것들 리스트 전체 불러오기
	@GetMapping("/apv_cf_list_all")
	public String cflistall(Model m) {
		m.addAttribute("list", service.apv_cf_list_all());
		return "Apv_cf_list_all";
	}

//	결재완료된것들 리스트 상세 불러오기
	@GetMapping("/Apv_cf_detail")
	public String apv_cf_detail(int apv_no, Model m) {
		m.addAttribute("list", service.apv_cf_detail(apv_no));
		return "Apv_cf_detail";
	}

//	반려처리함 리스트 페이지 불러오기
	@GetMapping("/Apv_rjt")
	public String rjt(Apv_vc_dto vc) {
		service.apv_rjt(vc);
		return "redirect:/apv_wait_list";
	}

//	반려처리함 리스트 전체 불러오기
	@GetMapping("/Apv_rjt_list")
	public String apv_rjt_list(HttpSession session, Model m) {
		m.addAttribute("list", service.apv_rjt_list(session));
		return "Apv_rjt_list";
	}

//	반려처리함 리스트 상세 불러오기
	@GetMapping("/Apv_rjt_detail")
	public String apv_rjt_detail(int apv_no, Model m) {
		m.addAttribute("list", service.apv_rjt_detail(apv_no));
		return "/Apv_rjt_detail";
	}

}