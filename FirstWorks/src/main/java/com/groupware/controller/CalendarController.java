package com.groupware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.groupware.dto.Cal_dto;
import com.groupware.service.CalendarService;

@Controller
public class CalendarController {
	@Autowired
	CalendarService service;

	// 캘린더 화면 불러오기
	@GetMapping("/Calendar_form")
	public String Calendar() {
		return "Calendar_form";
	}

	// 캘린더에 데이터 넣기
	@PostMapping("/cal_insert_pro")
	public String addCal(Cal_dto cal) {
		service.addCal(cal);
		return "redirect:/";
	}
}
