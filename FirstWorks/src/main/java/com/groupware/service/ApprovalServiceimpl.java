package com.groupware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.dto.Apv_over_dto;
import com.groupware.dto.Apv_vc_dto;
import com.groupware.dto.Mem_dto;
import com.groupware.mapper.ApprovalMapper;

@Service
public class ApprovalServiceimpl implements ApprovalService {
	@Autowired
	ApprovalMapper mapper;

	public List<Mem_dto> test() {
		return mapper.test();
	}

//	휴가신청서 입력
	public void apv_vc_insert(Apv_vc_dto board) {
		mapper.apv_vc_insert(board);
	}

//	휴가신청서 리스트 불러오기(사원번호)
	public List<Apv_vc_dto> apv_vc_list(Apv_vc_dto board) {
		return mapper.apv_vc_list(board);
	}

//	휴가신청서 불러오기(문서번호)
	public Apv_vc_dto apv_vc_detail(Apv_vc_dto board) {
		return mapper.apv_vc_detail(board);
	}

//	시간외근무 신청서 입력
	public void apv_over_insert(Apv_over_dto board) {
		mapper.apv_over_insert(board);
	}

//	시간외근무 신청서 리스트 불러오기(사원번호)
	public List<Apv_over_dto> apv_over_list(Apv_over_dto board) {
		return mapper.apv_over_list(board);
	}

//	시간외근무 신청서 불러오기(문서번호)
	public Apv_over_dto apv_over_detail(Apv_over_dto board) {
		return mapper.apv_over_detail(board);
	}

}