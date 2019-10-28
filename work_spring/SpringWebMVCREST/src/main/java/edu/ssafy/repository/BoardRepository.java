package edu.ssafy.repository;

import java.util.List;

import edu.ssafy.dto.BoardDto;
import edu.ssafy.dto.BoardResult;

public interface BoardRepository {
	public void insert(BoardDto dto) throws Exception;
	public List<BoardResult> selectList() throws Exception;
	public void update(BoardDto dto) throws Exception;
	public void delete(String num);
	public BoardDto selectOne(String num);
}
