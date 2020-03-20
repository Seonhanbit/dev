package com.ssafy.vote.dao;

import java.util.List;

import com.ssafy.vote.dto.MiddlepartVO;

public interface IMiddlepartDao {
	/**
	 * @author : 선한빛
	 * 기능 : 모든  중분류 리스트 조회하기
	 * @Date : 2020. 1. 28.
	 */
	public List<MiddlepartVO> getMiddlepartAllList();
	/**
	 * @author : 선한빛
	 * 기능 : 중분류 삽입
	 * @Date : 2020. 1. 28.
	 */
	public boolean insertMiddlepart(String code, String name, String mainpart, String areaCode);
	/**
	 * @author : 선한빛
	 * 기능 : 중분류 삭제
	 * @Date : 2020. 1. 28.
	 */
	public boolean delMiddlepart(String code);
	/**
	 * @author : 선한빛
	 * 기능 : 중분류 업데이트 하기
	 * @Date : 2020. 1. 28.
	 */
	public boolean updateMiddlepart(String code,  String name, String mainpart, String areaCode);
	/**
	 * @author : 선한빛
	 * 기능 : 대분류code에 해당하는 중분류 리스트 뽑기
	 * @Date : 2020. 1. 29.
	 */
	public List<MiddlepartVO> getMaincodeAllList(String maincode);
}
