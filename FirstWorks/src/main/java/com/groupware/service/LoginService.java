package com.groupware.service;

import javax.servlet.http.HttpSession;

public interface LoginService {

//	멤버 레벨 가져오기
	public int get_mem_rank(HttpSession session);

//	로그인
	public void login(int mem_no, HttpSession session);

//	로그아웃
	public void logout(HttpSession session);
}
