package com.groupware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.groupware.dto.Mem_dto;

@Controller
public class ManagerController {

	// 사원 등록 (사원번호, 결재도장 등)
	@GetMapping("/Mem_form")
	public String mem_form() {
		return "Mem_form";
	}

	// 사원 등록
	@PostMapping("/mem_insert_pro")
	public String mem_insert(Mem_dto dto) {
		// service.mem_insert(dto);
		return "redirect:/";
	}

}
