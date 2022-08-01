package com.groupware.service;

import java.util.List;

import com.groupware.dto.BoardVO;

public interface BoardService {

	public void register(BoardVO board);

	public BoardVO get(Long bno);

	public boolean modify(BoardVO board);

	public boolean remove(Long bno);

	public List<BoardVO> getList();

}
