package com.groupware.dto;

import lombok.Data;

@Data
public class Apv_dto {
	private int apv_no;	// 문서번호
	private int mem_no; // 결재요청자
	private int apv_mid_cf; // 중간결재자
	private int apv_fnl_cf; // 최종결재자
	private int apv_cf_no; // 결재완료여부
}
