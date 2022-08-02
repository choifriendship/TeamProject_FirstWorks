package com.groupware.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "loginform";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// service.logout(session);
		return "redirect:/";
	}

	@PostMapping("/loginpro")
	public String loginpro(int mem_no, HttpSession session) {
		// service.login(mem_no, session);
		return "redirect:/";
	}

}
