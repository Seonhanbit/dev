package com.ssafy.vote.dao;

import java.util.List;

import com.ssafy.vote.dto.AreaVO;

public interface IAreaDao {
	/**
	 * @author : 선한빛
	 * 기능 : 모든 지역구 리스트 조회하기
	 * @Date : 2020. 1. 28.
	 */
	public List<AreaVO> getAreaAllList();
	/**
	 * @author : 선한빛
	 * 기능 : 지역 삽입
	 * @Date : 2020. 1. 28.
	 */
	public boolean insertArea(String areaCode, String name);
	/**
	 * @author : 선한빛
	 * 기능 : 지역 삭제
	 * @Date : 2020. 1. 28.
	 */
	public boolean delArea(String areaCode);
	/**
	 * @author : 선한빛
	 * 기능 : 지역 업데이트 하기
	 * @Date : 2020. 1. 28.
	 */
	public boolean updateArea(String areaCode, String name);
}
