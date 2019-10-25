package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.Board;

public interface BoardService {
	void insert(String title, String writer, String context);
	void update(String title, String writer, String context, String seq);
	void delete(String seq);
	List<Board> list();
	Board get(String seq);
}
