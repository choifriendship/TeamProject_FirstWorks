package com.groupware.mapper;

import org.apache.ibatis.annotations.Select;

public interface MemberMapper {

//	멤버 레벨 가져오기
	@Select("select rank_no from mem_tb where mem_no = #{mem_no}")
	public int get_mem_rank(int mem_no);

}
