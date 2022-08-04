
package com.groupware.service;

import java.util.List;

import com.groupware.dto.Apv_over_dto;
import com.groupware.dto.Apv_vc_dto;
import com.groupware.dto.Mem_dto;

public interface GroupwareService {
	public List<Mem_dto> test();
	
//	휴가신청서 입력
	public void apv_vc_insert(Apv_vc_dto board);

//	휴가신청서 리스트 불러오기(사원번호)
	public List<Apv_vc_dto> apv_vc_list(Apv_vc_dto board);

//	휴가신청서 불러오기(문서번호)
	public Apv_vc_dto apv_vc_detail(Apv_vc_dto board);

//	시간외근무 신청서 입력
	public void apv_over_insert(Apv_over_dto board);

//	시간외근무 신청서 리스트 불러오기(사원번호)
	public List<Apv_over_dto> apv_over_list(Apv_over_dto board);

//	시간외근무 신청서 리스트 불러오기(문서번호)
	public Apv_over_dto apv_over_detail(Apv_over_dto board);
}
