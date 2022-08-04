package com.groupware.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.dto.Cal_dto;
import com.groupware.mapper.CalendarMapper;

@Service
public class CalendarServiceImpl implements CalendarService {
	@Autowired
	CalendarMapper mapper;

	@Override
	public void addCal(Cal_dto cal) {
		mapper.insert_cal(cal);
	}

//	@Override
//	public int delCal(int cal_no) {
//		return mapper.delete_cal(cal_no);
//	}
//
//	@Override
//	public Cal_dto updateCal(Cal_dto cal) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
