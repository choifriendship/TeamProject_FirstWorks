package com.groupware.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Board_dto {

	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
}
