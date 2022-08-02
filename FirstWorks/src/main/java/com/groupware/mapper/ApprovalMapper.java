package com.groupware.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.groupware.dto.Apv_dto;
import com.groupware.dto.Apv_vc_dto;
import com.groupware.dto.Apv_wait_dto;

public interface ApprovalMapper {

//	대기테이블 리스트 첫번째
	@Select("select * from apv_vc_tb a, apv_wait_tb b where a.apv_no = b.apv_no " + "and b.apv_str_cf = #{mem_no} "
			+ "order by a.apv_no desc")
	public List<Apv_wait_dto> apv_wait_list(int mem_no);

//	대기테이블 리스트 두번째
	@Select("select * from apv_vc_tb a, apv_wait_tb b where a.apv_no = b.apv_no and b.apv_line_two = #{mem_no} order by a.apv_no desc")
	public List<Apv_wait_dto> apv_wait_list1(int mem_no);

//	대기테이블 리스트 세번째
	@Select("select * from apv_vc_tb a, apv_wait_tb b where a.apv_no = b.apv_no and b.apv_line_three = #{mem_no}"
			+ "order by a.apv_no desc")
	public List<Apv_wait_dto> apv_wait_list2(int mem_no);

//	대기테이블에서 휴가 상세보기 가져오기
	@Select("select * from apv_vc_tb where apv_no = #{apv_no}")
	public Apv_vc_dto apv_wait_detail(int apv_no);

//	대기테이블에 중간결재자 업데이트
	@Update("update apv_wait_tb set apv_mid_cf = #{apv_line_two} where apv_no=#{apv_no}")
	public void apv_wait_update1(@Param("apv_line_two") int apv_line_two, @Param("apv_no") int apv_no);

//	휴가테이블에 중간결재자 업데이트(휴가 본문에 도장 업데이트문)
	@Update("update apv_vc_tb set mem_stamp_two = (select mem_stamp from mem_tb where mem_no = #{apv_line_two}) where apv_no = #{apv_no}")
	public void apv_vc_update1(@Param("apv_line_two") int apv_line_two, @Param("apv_no") int apv_no);

// 	대기테이블에 최종결재자 업데이트(승인테이블에 승인란(cf)에 1로 업데이트)
	@Update("update apv_wait_tb set apv_fnl_cf = #{apv_line_three} where apv_no = #{apv_no}")
	public void apv_wait_update2(@Param("apv_line_three") int apv_line_three, @Param("apv_no") int apv_no);

//	휴가테이블에 최종결재자 업데이트(휴가본문에 도장 업데이트문)
	@Update("update apv_vc_tb set mem_stamp_three = (select mem_stamp from mem_tb where mem_no = #{apv_line_three}) where apv_no = #{apv_no}")
	public void apv_vc_update2(@Param("apv_line_three") int apv_line_three, @Param("apv_no") int apv_no);

//	승인테이블에 최종결재자 결재완료 승인확인란(cf)에 1을 넣어서 승인완료처리 (0은 결재대기)
	@Update("update apv_tb set apv_cf_no = 1 where apv_no = #{apv_no}")
	public void apv_cf(int apv_no);

//	대기테이블에서 삭제(완료테이블로 가기 위해)
	@Delete("delete from apv_wait_tb where apv_no = #{apv_no}")
	public void apv_wait_del(int apv_no);

//	결재완료된것들 리스트 페이지 불러오기(자기가 결재한 문서들만)
	@Select("select * from apv_tb a, apv_vc_tb b " + "where a.apv_no=b.apv_no " + "and a.apv_cf_no = 1"
			+ "and (a.apv_line_one = #{mem_no}" + "or a.apv_line_two = #{mem_no}" + "or apv_line_three = #{mem_no})"
			+ "order by b.apv_no desc")
	public List<Apv_dto> apv_cf_list(int mem_no);

//	결재완료된것들 리스트 전체 불러오기
	@Select("select * " + "from apv_tb a, apv_vc_tb b" + "" + "where a.apv_no = b.apv_no " + "and a.apv_cf_no = 1 "
			+ "order by b.apv_no desc")
	public List<Apv_dto> apv_cf_list_all();

//	결재완료테이블 디테일
	@Select("select * from apv_tb a, apv_vc_tb b where apv_no = #{apv_no}")
	public Apv_vc_dto apv_cf_detail(int apv_no);

//	휴가신청서 입력하기 (휴가신청서 테이블, 전자결재 테이블, 결재대기함 동시에 입력)
	@Insert("insert all into apv_vc_tb(mem_no, apv_vc_tit, apv_vc_file, apv_vc_rjt, apv_vc_cf_no, apv_vc_txt, apv_vc_str_dt, apv_vc_end_dt, dept_no, apv_no) "
			+ "values (#{mem_no}, #{apv_vc_tit}, #{apv_vc_file}, #{apv_vc_rjt}, #{apv_vc_cf_no}, #{apv_vc_txt}, #{apv_vc_str_dt}, #{apv_vc_end_dt}, #{dept_no}, inc_seq.NEXTVAL) "
			+ "into apv_tb (apv_no, mem_no, apv_no) values (inc_seq.NEXTVAL, #{mem_no}, inc_seq.NEXTVAL) "
			+ "into apv_wait_tb (apv_no, apv_str_cf, apv_line_one) values (inc_seq.NEXTVAL, #{mem_no}, #{mem_no}) "
			+ "select * from dual")
	public void apv_vc_insert(Apv_vc_dto vc);

//	중간결재자가 휴가신청 할때 승인문서작성문
	@Insert("insert into apv_tb values (#{apv_no}, #{mem_no}, #{apv_mid_cf}, #{apv_fnl_cf}, #{apv_cf_no})")
	public void apv_vc_insert1_cf(Apv_vc_dto vc);

//	중간결재자가 휴가신청 할때 휴가본문작성문
	@Insert("insert into apv_vc_tb values (#{mem_no}, #{apv_vc_tit}, #{apv_vc_file}, #{apv_vc_rjt}, #{apv_no}, #{apv_vc_txt}, #{apv_vc_str_dt}, #{apv_vc_end_dt}, #{dept_no}, inc_seq.NEXTVAL, 0, (select mem_stamp_two from mem_tb where mem_no = #{mem_no}),0)")
	public void apv_vc_insert1(Apv_vc_dto vc);

//	중간결재자가 휴가신청 할때 대기문서함에 생성문
	@Insert("insert into apv_wait_tb values (#{apv_no}, 0, apv_str_cf = #{mem_no}, 0, 0, 0")
	public void apv_vc_wait_insert1(Apv_vc_dto vc);

//  최종결재자가 휴가신청할때 승인테이블에 생성함(전결임)
	@Insert("insert into apv_tb values (#{apv_no}, 0, 0, #{mem_no}, 1)")
	public void apv_vc_insert2_cf(Apv_vc_dto vc);

//  최종결재자가 휴가신청할때 휴가본문테이블에 생성함
	@Insert("insert into apv_vc_tb values (#{mem_no}, #{apv_vc_tit}, #{apv_vc_file}, #{apv_vc_rjt}, #{apv_no}, #{apv_vc_txt}, #{apv_vc_str_dt}, #{apv_vc_end_dt}, #{dept_no}, inc_seq.NEXTVAL, 0, 0, (select mem_stamp_two from mem_tb where mem_no = #{mem_no}))")
	public void apv_vc_insert2(Apv_vc_dto vc);

//  LEVEL1의 결재대기문서 숫자
	@Select("select count(b.apv_no) from apv_vc_tb a, apv_wait_tb b "
			+ "where a.apv_no = b.apv_no and b.apv_str_cf = #{mem_no}")
	public int apv_wait_cnt(int mem_no);

//  LEVEL2의 결재대기문서 숫자
	@Select("select count(b.apv_no) from apv_vc_tb a, apv_wait_tb b where a.apv_no = b.apv_no "
			+ "and b.apv_mid_cf = 0 " + "and b.apv_line_two = #{mem_no}")
	public int apv_wait_cnt1(int mem_no);

//  LEVEL3의 결재대기문서 숫자
	@Select("select count(b.apv_no) " + "from apv_vc_tb a, apv_wait_tb b " + "where a.apv_no = b.apv_no "
			+ "and b.apv_fnl_cf = 0 " + "and b.apv_mid_cf != 0 " + "and b.apv_line_three = #{mem_no}")
	public int apv_wait_cnt2(int mem_no);

//  반려시 반려사유 업데이트문
	@Update("update apv_vc_tb set apv_vc_rjt = #{apv_vc_rjt} where apv_no = #{apv_no}")
	public void apv_rjt_update(Apv_vc_dto vc);

//	휴가본문테이블에 있는 데이터가 반려테이블로 복사 (1)
	@Insert("insert into apv_rjt_tb select * from apv_vc_tb wheres apv_no = #{apv_no}")
	public void apv_rjt_copy(Apv_vc_dto vc);

//	반려가 됐을 시 휴가본문테이블에서 삭제 (2)
	@Delete("delete from apv_vc_tb where apv_no = #{apv_no}")
	public void apv_rjt_del(Apv_vc_dto vc);

//	반려리스트
	@Select("select * from apv_tb a, apv_rjt_tb b where a.apv_no = b.apv_no and (a.mem_no = #{mem_no} "
			+ "or a.apv_line_two = #{mem_no} " + "or a.apv_line_three = #{mem_no}) " + "order by b.apv_no desc")
	public List<Apv_wait_dto> apv_rjt_list(Integer mem_no);

//	반려테이블 디테일
	@Select("select * from apv_rjt_tb where apv_no = #{apv_no}")
	public Apv_vc_dto apv_rjt_detail(int apv_no);

}
