package com.groupware.service;

import java.util.List;

import com.groupware.dto.Board_dto;

public interface BoardService {

	public void register(Board_dto board);

	public Board_dto get(Long bno);

	public boolean modify(Board_dto board);

	public boolean remove(Long bno);

	public List<Board_dto> getList();

}
