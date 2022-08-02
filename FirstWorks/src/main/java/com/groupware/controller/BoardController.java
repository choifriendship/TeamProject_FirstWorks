package com.groupware.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

import com.groupware.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class BoardController {
	@Autowired
	private BoardService service;

	@InitBinder
	public void initbinder(WebDataBinder binder) {
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(d, false));
	}

	@GetMapping("/list") // 목록
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
	}
}
