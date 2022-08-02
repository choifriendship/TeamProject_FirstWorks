package com.groupware.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("/Login_form")
	public String login() {
		return "Login_form";
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
