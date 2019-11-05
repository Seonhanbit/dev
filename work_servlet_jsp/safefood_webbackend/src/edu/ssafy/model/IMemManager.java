package edu.ssafy.model;

public interface IMemManager {

	boolean addMem(String id, String pw, String name, String addr, String email, String tel, String alinfo);
	boolean isLogin(String id, String pw);
	void close();
	boolean updateMem(String id, String pw, String name, String addr, String email, String tel, String alinfo);
	boolean delMem(String id);
	MemVO getMemInfo(String id);
	String searchpw(String id, String name);

}
