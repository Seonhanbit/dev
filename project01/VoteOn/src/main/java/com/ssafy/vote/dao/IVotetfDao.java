package com.ssafy.vote.dao;

import java.util.List;

public interface IVotetfDao {
	/**
	 * @author : 선한빛
	 * 기능 : 투표 유무를 등록하는 기능
	 * @Date : 2020. 1. 29.
	 */
	public boolean insertVotetf(String votercode, int votecode);
	/**
	 * @author : 선한빛
	 * 기능 : 투표 유무를 삭제하는 기능
	 * @Date : 2020. 1. 29.
	 */	
	public boolean delVotetf(String votercode, int votecode);
	/**
	 * @author : 선한빛
	 * 기능 : 투표자코드 입력값 -> 투표 고유키를 알아내는 기능
	 * @Date : 2020. 1. 29.
	 */
	public List<Integer> getvotecode(String votercode);
}
