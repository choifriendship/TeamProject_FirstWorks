package com.groupware.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Apv_vc_dto {

	private int apv_no;
	private String mem_no;
	private String apv_vc_tit;
	private String apv_vc_file;
	private String apv_vc_rjt;
	private int apv_vc_cf_no;
	private String apv_vc_txt;
	private Date apv_vc_str_dt;
	private Date apv_vc_end_dt;
	private String dept_no;
}
