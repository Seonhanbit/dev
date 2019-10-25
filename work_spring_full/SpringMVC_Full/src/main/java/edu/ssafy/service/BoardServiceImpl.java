package edu.ssafy.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.dto.Board;
import edu.ssafy.dto.Member;
import edu.ssafy.repository.BoardRepository;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	@Qualifier("BoardRepositoryImplMyBatis")
	private BoardRepository repo;
	
	@Override
	public void insert(String title, String writer, String content) {
		Board b = new Board();
		b.setTitle(title);
		b.setWriter(writer);
		b.setContent(content);
		repo.insert(b);
	}

	@Override
	public void update(String title, String writer, String content, String seq) {
		try {
			Board b = new Board();
			b.setTitle(title);
			b.setWriter(writer);
			b.setContent(content);
			b.setSeq(Integer.parseInt(seq));
			repo.update(b);
		}catch(NumberFormatException e) {
		}
		
	}
	

	@Override
	public void delete(String seq) {
		try {
			repo.delete(Integer.parseInt(seq));
		}catch(NumberFormatException e) {
			
		}
	}

	@Override
	public List<Board> list() {
		
		return repo.list();
	}

	@Override
	public Board get(String seq) {
		Board b = null;
		try {
			b = repo.get(Integer.parseInt(seq));
			if(b != null) {
				repo.countUp(b.getSeq());
				b.setCount(b.getCount()+1);
			}
		}catch(NumberFormatException e) {
			
		}
		return b;
	}




}
