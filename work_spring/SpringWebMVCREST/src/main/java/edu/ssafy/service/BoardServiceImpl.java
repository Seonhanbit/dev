package edu.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ssafy.dto.BoardDto;
import edu.ssafy.dto.BoardResult;
import edu.ssafy.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository repo;

	@Override
	public void insert(String num, String title, String content) throws Exception {
		repo.insert(new BoardDto(num, title, content));		
	}

	@Override
	public List<BoardResult> selectList() throws Exception {
		return repo.selectList();
	}

	@Override
	public void update(String num, String title, String content) throws Exception {
		repo.update(new BoardDto(num, title, content));
	}

	@Override
	public void delete(String num) {
		repo.delete(num);		
	}

	@Override
	public BoardDto selectOne(String num) {
		return repo.selectOne(num);
	}
}
