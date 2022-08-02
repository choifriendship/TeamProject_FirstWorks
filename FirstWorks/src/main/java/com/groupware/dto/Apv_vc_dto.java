package com.groupware.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Apv_vc_dto {

	private int mem_no; // 사원번호
	private String apv_vc_tit; // 신청서 제목
	private String apv_vc_file; // 첨부파일
	private String apv_vc_rjt; // 반려사유
	private int apv_vc_cf_no; // 승인번호
	private String apv_vc_txt; // 결재내용
	private Date apv_vc_str_dt; // 휴가시작날짜
	private Date apv_vc_end_dt; // 휴가종료날짜
	private String dept_no; // 기안부서
	private int apv_vc_no; // 휴가신청서
	private String mem_stamp_one; // 기안자 결재 도장
	private String mem_stamp_two; // 중간결재자 결재 도장
	private String mem_stamp_three; // 최종결재자 결재 도장
}

// 휴가신청서 번호 삭제하고 문서번호 불러와야함.
