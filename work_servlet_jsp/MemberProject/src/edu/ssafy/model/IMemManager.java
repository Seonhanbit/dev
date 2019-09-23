package edu.ssafy.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IMemManager {
	public boolean addMem(String id, String name, String pw, String addr, int age, String tel);

	public boolean delMem(String id);

	public boolean updateMem(String id, String name, String pw, String addr, int age, String tel);

	public ArrayList<MemVO> getList();

	public MemVO memInfo(String id);

	public void close();
	
	public boolean loginInfo(String id, String pw);
}
