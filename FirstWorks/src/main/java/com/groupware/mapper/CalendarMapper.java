package com.groupware.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.groupware.dto.Cal_dto;

public interface CalendarMapper {

// 일정 삽입
	@Insert("INSERT INTO cal_tb VALUES(cal_inc.NEXTVAL, #{mem_no}, #{cal_type}, #{cal_str}, "
			+ "#{cal_end}, #{cal_title}, #{cal_txt}, #{cal_color}, #{cal_all}, sysdate)")
	public void insert_cal(Cal_dto cal);

//	일정 삭제
	@Delete("DELETE cal_tb WHERE cal_no = #{cal_no}")
	public void delete_cal(int cal_no);

// 일정 변경
	@Update("UPDATE cal_tb SET cal_type = #{cal_type}, cal_str = #{cal_str}, cal_end = #{cal_end}, "
			+ "cal_title = #{cal_title}, cal_txt = #{cal_txt}, cal_color = #{cal_color}, cal_all = #{cal_all} "
			+ "where cal_no = #{cal_no}")
	public void update_cal(Cal_dto cal);

//	최근 일정 확인
	@Select("SELECT * FROM cal_tb WHERE mem_no = #{mem_no}")
	public void select_cal(int mem_no);

}
