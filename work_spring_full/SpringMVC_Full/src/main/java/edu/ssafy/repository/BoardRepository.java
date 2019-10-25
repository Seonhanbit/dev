package edu.ssafy.repository;

import java.util.List;

import edu.ssafy.dto.Board;


public interface BoardRepository {
	void insert(Board b);
	void update(Board b);
	void delete(int seq);
	List<Board> list();
	Board get(int seq);
	void countUp(int seq);
}
