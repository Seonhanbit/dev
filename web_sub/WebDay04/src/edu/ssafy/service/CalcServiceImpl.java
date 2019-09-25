package edu.ssafy.service;

import java.util.ArrayList;

import edu.ssafy.model.Calc;

public class CalcServiceImpl implements IService {

	@Override
	public ArrayList<Calc> calc(int op1, int op2) {
		//알고리즘 구현하기 
		ArrayList<Calc> data = new ArrayList<>();
		data.add(new Calc(op1, op2, op1+op2));
		data.add(new Calc(op1+1, op2+1, op1+op2+2));
		data.add(new Calc(op1+2, op2+2, op1+op2+4));
		
		return data;
	}

}
