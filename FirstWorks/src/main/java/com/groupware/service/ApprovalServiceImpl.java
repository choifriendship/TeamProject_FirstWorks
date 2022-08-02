package com.groupware.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.dto.Apv_dto;
import com.groupware.dto.Apv_vc_dto;
import com.groupware.dto.Apv_wait_dto;
import com.groupware.mapper.ApprovalMapper;

@Service
public class ApprovalServiceImpl implements ApprovalService {
	@Autowired
	ApprovalMapper mapper;

//	멤버 레벨 가져오기
	public int getrank(HttpSession session) {
		int mem_no = (Integer) session.getAttribute("mem_no");
		return mapper.getrank(mem_no);
	}

//	대기테이블 첫번째
	public List<Apv_wait_dto> waitlist(HttpSession session) {
		int mem_no = (Integer) session.getAttribute("mem_no");
		return mapper.waitlist(mem_no);
	}

//	대기테이블 두번째
	public List<Apv_wait_dto> waitlist1(HttpSession session) {
		int mem_no = (Integer) session.getAttribute("mem_no");
		return mapper.waitlist(mem_no);
	}

//	대기테이블 세번째
	public List<Apv_wait_dto> waitlist2(HttpSession session) {
		int mem_no = (Integer) session.getAttribute("mem_no");
		return mapper.waitlist(mem_no);
	}

//	대기테이블에서 휴가 상세보기 가져오기
	public Apv_vc_dto waitlistdetail(int apv_no) {
		return mapper.waitlistdetail(apv_no);
	}

//	대기테이블에 중간결재자 업데이트
//	휴가테이블에 중간결재자 업데이트(휴가 본문에 도장 업데이트문)
	public void midcf(HttpSession session, int apv_no) {
		int mem_no = (Integer) session.getAttribute("mem_no");
		mapper.midcf(mem_no, apv_no);
		mapper.midcf1(mem_no, apv_no);
	}

//	대기테이블에 최종결재자 업데이트(승인테이블에 승인란(cf)에 1로 업데이트)
//	휴가테이블에 최종결재자 업데이트(휴가본문에 도장 업데이트문)
//	최종결재자 결재완료 승인테이블에 승인확인란(cf)에 1을 넣어서 승인완료처리 (0은 결재대기)
//	대기테이블에서 삭제(완료테이블로 가기 위해)
	public void fnlcf(HttpSession session, int apv_no) {
		int mem_no = (Integer) session.getAttribute("mem_no");
		mapper.fnlcf(mem_no, apv_no);
		mapper.fnlcf1(mem_no, apv_no);
		mapper.fnlcf2(apv_no);
		mapper.waitdel(apv_no);
	}

//	결재완료된것들 리스트 페이지 불러오기(자기가 결재한 문서들만)
	public List<Apv_dto> cflist(HttpSession session) {
		int mem_no = (Integer) session.getAttribute("mem_no");
		return mapper.cflist(mem_no);
	}

//	결재완료된것들 리스트 전체 불러오기
	public List<Apv_dto> cflistall() {
		return mapper.cflistall();
	}

//	결재완료된 것을 리스트 상세 불러오기
	public Apv_vc_dto apv_cf_detail(int apv_no) {
		return mapper.cf_list_detail(apv_no);

	}

//	휴가신청서 입력하기 (휴가신청서 테이블, 전자결재 테이블, 결재대기함 동시에 입력)
	public void apv_vc_insert(Apv_vc_dto vc, HttpSession session) {
		int mem_no = (Integer) session.getAttribute("mem_no");
		vc.setMem_no(mem_no);
		mapper.apv_vc_insert(vc, session);
	}

//	중간결재자가 휴가신청 할때 승인문서작성문
//	중간결재자가 휴가신청 할때 휴가본문작성문
//	중간결재자가 휴가신청 할때 대기문서함에 생성문
	public void apv_vc_insert1(Apv_vc_dto vc, HttpSession session) {
		int mem_no = (Integer) session.getAttribute("mem_no");
		vc.setMem_no(mem_no);
		mapper.apv_vc_insert1_cf(vc);
		mapper.apv_vc_insert1(vc);
		mapper.apv_vc_wait_insert1(vc);
	}

//  최종결재자가 휴가신청할때 승인테이블에 생성함(전결임)
//  최종결재자가 휴가신청할때 휴가본문테이블에 생성함
	public void apv_vc_insert2(Apv_vc_dto vc, HttpSession session) {
		int mem_no = (Integer) session.getAttribute("mem_no");
		vc.setMem_no(mem_no);
		mapper.apv_vc_insert2_cf(vc);
		mapper.apv_vc_insert2(vc);

	}

//  LEVEL1의 결재대기문서 숫자
	public int waitcnt(int mem_no) {
		return mapper.waitcnt(mem_no);
	}

//  LEVEL2의 결재대기문서 숫자
	public int waitcnt1(int mem_no) {
		return mapper.waitcnt1(mem_no);
	}

//  LEVEL3의 결재대기문서 숫자
	public int waitcnt2(int mem_no) {
		return mapper.waitcnt2(mem_no);
	}

//  반려시 반려사유 업데이트문
//	휴가본문테이블에 있는 데이터가 반려테이블로 복사 (1)
//	반려가 됐을 시 휴가본문테이블에서 삭제 (2)
//	대기테이블에서 삭제(완료테이블로 가기 위해)
	public void rjt(Apv_vc_dto vc) {
		mapper.rjtupdate(vc);
		mapper.rjtcopy(vc);
		mapper.rjtdel(vc);
		mapper.waitdel(vc.getApv_vc_no());
	}

//	반려리스트
	public List<Apv_wait_dto> rjtlist(HttpSession session) {
		return mapper.rjtlist((Integer) session.getAttribute("mem_no"));
	}

//	반려테이블 디테일
	public Apv_vc_dto rjtdetail(int apv_no) {
		return mapper.rjtdetail(apv_no);
	}

}
