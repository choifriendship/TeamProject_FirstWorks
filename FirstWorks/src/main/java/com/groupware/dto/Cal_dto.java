package com.groupware.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Cal_dto {

	private int cal_no; // 일정 번호
	private int mem_no; // 사원 번호
	private int cal_type; // 일정 종류
	private String cal_str; // 일정시작일
	private String cal_end; // 일정마감일
	private String cal_title; // 일정 제목
	private String cal_txt; // 일정 내용
	private String cal_color; // 일정 색상
	private int cal_all; // 종일
	private Date cal_date; // 일정입력일

}
