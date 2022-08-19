package com.groupware.dto;

import java.sql.Date;



import lombok.Data;

@Data
public class EmailDTO {
	private int mailnum;//메일번호
	private int memnum;// 사원번호
	private String sendermail; //보낸메일
	private String receivemail; //받은 메일
	private String title; //제목
	private String content; //내용
	private Date registerDate;//등록일
	private int readck; //읽음 여부 CK 읽으면 1 읽지않으면 0(기본설정)
	private int delck; //삭제 여부 CK (기본설정:0 )
	
	
	//페이징
	private int offset;
	private int pagesize;
	private int page;
	
	
	//MEM_TB
	private String mem_no;
	private int dept_no;
	private String mem_id;
	private String mem_pw;
	private String mem_nm;
	private String mem_eml;
	private Date mem_ent;
	private int mem_tel;
	private String mem_stamp;
	private int rank_no;
	
	
	
	public void execute() { //offset 실행
		offset=(page-1)*pagesize;
	}

	
	
	
	//������ �Խñ� �о������ (1) -> delete ���� �ʰ� delck 1�� ������Ʈ �ؼ� �����Ը� �Ⱥ��̰�
	//������ �Խñ��� ���� �ʾ������ (0) ->db ������ ���� 

	

	

}
