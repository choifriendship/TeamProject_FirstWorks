package com.groupware.service;

import javax.servlet.http.HttpSession;

public interface LoginService {
	
	public void login(int mem_no, HttpSession session);
}
