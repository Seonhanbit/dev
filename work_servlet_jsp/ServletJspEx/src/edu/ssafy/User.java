package edu.ssafy;

public class User {

	private String id;
	private String passwd;
	
	public User(String id, String passwd) {
		super();
		this.id = id;
		this.passwd = passwd;
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", passwd=" + passwd + "]";
	}
	
	
}
