package com.ssafy.vote.service;

import java.util.List;

public interface IVotetfService {
	/**
	 * @author : 선한빛
	 * 기능 : 투표 유무를 등록하는 기능
	 * @Date : 2020. 1. 29.
	 */
	public boolean insertVotetf(int votercode, int votecode);
	/**
	 * @author : 선한빛
	 * 기능 : 투표 유무를 삭제하는 기능
	 * @Date : 2020. 1. 29.
	 */	
	public boolean delVotetf(int votercode, int votecode);
	/**
	 * @author : 선한빛
	 * 기능 : 투표자코드 입력값 -> 투표 고유키를 알아내는 기능
	 * @Date : 2020. 1. 29.
	 */
	public List<Integer> getvotecode(int votercode);
}
