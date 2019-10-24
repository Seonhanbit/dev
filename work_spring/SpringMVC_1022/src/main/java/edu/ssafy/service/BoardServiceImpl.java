package edu.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ssafy.repository.BoardRepository;
import edu.ssafy.util.BoardDto;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardRepository rep;

	@Override
	public void insert(String no, String title, String content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String no, String title, String content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardDto selectOne(String no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}
}
