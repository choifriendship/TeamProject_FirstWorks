package com.groupware.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.groupware.dto.Mem_dto;

public interface MemberMapper {

//	사원 등록
	@Insert("insert into mem_tb values (#{mem_no}, #{dept_no}, #{mem_id}, #{mem_pw},"
			+ "#{mem_nm}, #{mem_eml}, sysdate, #{mem_tel}, #{mem_stamp}, #{rank_no})")
	public void mem_insert(Mem_dto mem);

//	멤버 레벨 가져오기
	@Select("select rank_no from mem_tb where mem_no = #{mem_no}")
	public int get_mem_rank(int mem_no);

}
