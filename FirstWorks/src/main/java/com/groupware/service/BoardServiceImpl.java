package com.groupware.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.groupware.dto.Board_dto;
import com.groupware.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

//	@Setter(onMethod_ = @Autowired)
//	private BoardMapper mapper;

	// spring 4.3. 이상에서 자동 처리
	private BoardMapper mapper;

	@Override
	public void register(Board_dto board) {

		log.info("register......" + board);

		mapper.insertSelectKey(board);

	}

	@Override
	public Board_dto get(Long bno) {

		log.info("get......" + bno);

		return mapper.read(bno);
	}

	@Override
	public boolean modify(Board_dto board) {

		log.info("modify......" + board);

		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {

		log.info("remove......" + bno);

		return mapper.delete(bno) == 1;
	}

	@Override
	public List<Board_dto> getList() {

		log.info("getList..........");

		return mapper.getList();
	}

}
