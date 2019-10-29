package edu.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ssafy.repository.BoardRepository;
import edu.ssafy.util.BoardDto;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardRepository rep;

	@Override
	@Transactional
	public int insert(String no, String title, String content) {
		return rep.insert(new BoardDto(no, title, content));
	}

	@Override
	@Transactional
	public int update(String no, String title, String content) {
		return rep.update(new BoardDto(no, title, content));
	}

	@Override
	@Transactional
	public int delete(String no) {
		return rep.delete(no);
		
	}

	@Override
	public BoardDto selectOne(String no) {
		
		return rep.selectOne(no);
	}

	@Override
	public List<BoardDto> selectList() {
		// TODO Auto-generated method stub
		return rep.selectList();
	}
}
