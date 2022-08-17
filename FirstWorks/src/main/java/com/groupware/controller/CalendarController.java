package com.groupware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import com.groupware.dto.CalendarDTO;
import com.groupware.service.CalendarService;



@Controller
public class CalendarController {
   @Autowired
   private CalendarService service;
   
   //캘린더 뷰 보여주는 메소드
   @RequestMapping(value = "/calendar", method = RequestMethod.GET)
   public String calendar() {          
         return "calendar/calendar";
   }
   
   //일정
   @RequestMapping(value = "/schedule", method = RequestMethod.GET)
   @ResponseBody
   public CalendarDTO calendar(@RequestParam  int id) throws Exception {
      return service.getCalendar(id);
   }

   //일정 목록
   @RequestMapping(value = "/calendarList", method = RequestMethod.GET)
   @ResponseBody
   public List<CalendarDTO> calendarList() throws Exception {
      return service.getList();
   }
   
   //일정 추가 메소드
   @RequestMapping(value = "/calendarInsert", method = RequestMethod.POST)
   @ResponseBody
   public String calendarInsert(CalendarDTO dto) throws Exception {
      dto.setTitle(HtmlUtils.htmlEscape(dto.getTitle()));
      dto.setTxt(HtmlUtils.htmlEscape(dto.getTxt()));
      service.add(dto);
      return "success";
   }
   
   //일정 변경
   @RequestMapping(value = "/calendarUpdate", method = RequestMethod.POST)
   @ResponseBody
   public String calendarUpdate(CalendarDTO dto) throws Exception {
      dto.setTitle(HtmlUtils.htmlEscape(dto.getTitle()));
      dto.setTxt(HtmlUtils.htmlEscape(dto.getTxt()));
      service.modify(dto);
      return "success"; 
   }

   //일정 삭제
   @RequestMapping(value = "/calendarRemove")
   @ResponseBody
   public String calendarRemove(@RequestParam int id) throws Exception {
      System.out.println(id);
      service.remove(id);
      return "calendar/calendar";
   }
}