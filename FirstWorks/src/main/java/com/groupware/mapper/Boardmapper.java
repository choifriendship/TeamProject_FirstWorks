package com.groupware.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.groupware.dto.Apv_over_dto;
import com.groupware.dto.Apv_vc_dto;
import com.groupware.dto.Mem_dto;

public interface Boardmapper {
	@Select("select * from mem_tb")
	public List<Mem_dto> test();

//	휴가신청서 입력하기
	@Insert("insert into apv_vc_tb values "
			+ "(#{apv_no, jdbcType=INTEGER},#{mem_no, jdbcType=VARCHAR},#{apv_vc_tit, jdbcType=VARCHAR},#{apv_vc_file, jdbcType=VARCHAR},#{apv_vc_rjt, jdbcType=VARCHAR},#{apv_vc_cf_no, jdbcType=INTEGER},#{apv_vc_txt, jdbcType=VARCHAR},#{apv_vc_str_dt},#{apv_vc_end_dt},#{dept_no, jdbcType=VARCHAR})")
	public void apv_vc_insert(Apv_vc_dto board);

//	휴가신청서 불러오기(사원번호) -> 대기문서
	@Select("select * from apv_vc_tb where mem_no=#{mem_no}")
	public List<Apv_vc_dto> apv_vc_list(Apv_vc_dto board);

//	휴가신청서 불러오기(문서번호) -> 대기문서를 클릭하면 들어가지는 곳
	@Select("select * from apv_vc_tb where apv_no=#{apv_no}")
	public Apv_vc_dto apv_vc_detail(Apv_vc_dto board);

// 시간외근무 신청서 입력하기
	@Insert("insert into apv_over_tb values"
			+ "(#{apv_no, jdbcType=INTEGER}, #{mem_no, jdbcType=VARCHAR}, #{apv_over_tit, jdbcType=VARCHAR}, #{apv_over_file, jdbcType=VARCHAR}, #{apv_over_rjt, jdbcType=VARCHAR}, #{apv_over_cf_no, jdbcType=INTEGER}, #{apv_over_txt, jdbcType=VARCHAR}, #{apv_over_str_hrs}, #{apv_over_end_hrs}, #{dept_no, jdbcType=VARCHAR} ")
	public void apv_over_insert(Apv_over_dto board);

//	시간외근무 신청서 불러오기(사원번호) -> 대기문서
	@Select("select * from apv_over_tb where mem_no=#{mem_no}")
	public List<Apv_over_dto> apv_over_list(Apv_over_dto board);

//	시간외근무 신청서 불러오기(문서번호) -> 대기문서를 클릭하면 들어가지는 곳
	@Select("select * from apv_over_tb where apv_no=#{apv_no}")
	public Apv_over_dto apv_over_detail(Apv_over_dto board);

}
