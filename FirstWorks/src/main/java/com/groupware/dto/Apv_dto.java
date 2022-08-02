package com.groupware.dto;

import lombok.Data;

@Data
public class Apv_dto {
	private int apv_no; // 문서번호
	private int apv_mem_no1; // 기안자
	private int apv_mem_no2; // 기안자2
	private int apv_mem_no3; // 기안자3
	private int apv_cf_no; // 결재완료여부
}
