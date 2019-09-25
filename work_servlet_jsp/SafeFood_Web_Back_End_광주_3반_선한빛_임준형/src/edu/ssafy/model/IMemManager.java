package edu.ssafy.model;

import java.io.IOException;
import java.util.ArrayList;

public interface IMemManager {
	public boolean addMem(String id, String pw, String name, String addr, String tel, String allergy);

	public boolean delMem(String id);

	public boolean updateMem(String id, String pw, String name, String addr, String tel);

	//public ArrayList<MemVO> getList();

	public void close();

	public MemVO memInfo(String id);

	public boolean loginInfo(String id, String pw) throws IOException;
	
	public String searchpw(String id, String name);
	
}
