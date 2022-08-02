package com.groupware.dto;

import lombok.Data;

@Data
public class Apv_wait_dto extends Apv_vc_dto {

	private int apv_str_cf; // 기안자 (사원 기안 시)
	private int apv_mid_cf; // 중간결재자
	private int apv_fnl_cf; // 최종결재자
	private int apv_line_one; // 결재선1
	private int apv_line_two; // 결재선2
	private int apv_line_three; // 결재선3

}
