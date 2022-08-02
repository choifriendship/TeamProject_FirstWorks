package com.groupware.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.mapper.MemberMapper;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	MemberMapper mapper;

//	멤버 레벨 가져오기
	public int get_mem_rank(HttpSession session) {
		int mem_no = (Integer) session.getAttribute("mem_no");
		return mapper.get_mem_rank(mem_no);
	}

	@Override
	public void login(int mem_no, HttpSession session) {
		session.setAttribute("mem_no", mem_no);
		session.setAttribute("rank_no", mapper.get_mem_rank(mem_no));
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

}
