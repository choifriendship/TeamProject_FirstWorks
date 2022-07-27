package com.groupware.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.groupware.dto.Apv_vc_dto;
import com.groupware.service.GroupwareService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class GroupwareController {
	@Autowired
	GroupwareService service;

	@InitBinder
	public void initbinder(WebDataBinder binder) {
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(d, false));
	}

	@GetMapping("/")
	public String index() {
		return "home";
	}

	// 휴가신청서를 불러온다.
	@GetMapping("/apv_vc_form") // localhost:8080/list 
	public String main(Model m) {
		m.addAttribute("list", service.test());
		return "Apv_vc_form";
	}

	// 결재대기함에 있는 휴가 신청서를 불러온다.
	@GetMapping("/apv_vc_list")
	public String apvlist(Model m) {
		Apv_vc_dto board = new Apv_vc_dto();
		board.setMem_no("asd");
		m.addAttribute("list1", service.apv_vc_list(board));
		return "Apv_vc_list";
	}

	// 결재대기함에 있는 휴가 신청서를 누르면 작성된 휴가신청서를 불러온다.
	@GetMapping("/apv_vc_detail")
	public String cfdetail(Apv_vc_dto board, Model m) {
		m.addAttribute("list2", service.apv_vc_detail(board));
		return "Apv_vc_detail";
	}

	 @PostMapping("/vcpro") 
	 public String vc_insert(Apv_vc_dto board) {
		 service.apv_vc_insert(board);		 
		 return "home";	 
	 }


}
