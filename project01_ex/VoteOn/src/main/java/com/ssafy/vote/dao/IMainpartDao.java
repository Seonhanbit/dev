package com.ssafy.vote.dao;

import java.util.List;

import com.ssafy.vote.dto.MainpartVO;

public interface IMainpartDao {
	/**
	 * @author : 선한빛
	 * 기능 : 모든  대분류 리스트 조회하기
	 * @Date : 2020. 1. 28.
	 */
	public List<MainpartVO> getMainpartAllList();
	/**
	 * @author : 선한빛
	 * 기능 : 대분류 삽입
	 * @Date : 2020. 1. 28.
	 */
	public boolean insertMainpart(String code, String name);
	/**
	 * @author : 선한빛
	 * 기능 : 대분류 삭제
	 * @Date : 2020. 1. 28.
	 */
	public boolean delMainpart(String code);
	/**
	 * @author : 선한빛
	 * 기능 : 대분류 업데이트 하기
	 * @Date : 2020. 1. 28.
	 */
	public boolean updateMainpart(String code, String name);
	
}
