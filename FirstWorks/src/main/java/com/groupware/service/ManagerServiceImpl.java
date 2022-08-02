package com.groupware.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.dto.Mem_dto;
import com.groupware.mapper.MemberMapper;

@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	MemberMapper mapper;

//	관리자모드에서 사원을 추가한다.
	public void mem_insert(Mem_dto mem) {
		mapper.mem_insert(mem);
	}

}
