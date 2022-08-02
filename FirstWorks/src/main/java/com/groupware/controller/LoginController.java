package com.groupware.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.groupware.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService service;

	@GetMapping("/Login_form")
	public String login() {
		return "Login_form";
	}

	@GetMapping("/Logout")
	public String logout(HttpSession session) {
		service.logout(session);
		return "redirect:/";
	}

	@PostMapping("/Login_pro")
	public String Login_pro(int mem_no, HttpSession session) {
		service.login(mem_no, session);
		return "redirect:/";
	}

}
