package com.groupware.mapper;

import java.util.List;

import com.groupware.dto.Board_dto;

public interface BoardMapper {

	public List<Board_dto> getList();

	public void insert(Board_dto board);

	public void insertSelectKey(Board_dto board);

	public Board_dto read(Long bno);

	public int delete(Long bno);

	public int update(Board_dto board);
}
