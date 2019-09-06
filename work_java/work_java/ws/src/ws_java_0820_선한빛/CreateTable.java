package ws_java_0820_선한빛;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/testdb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
				"ssafy", "ssafy");
		Statement st = con.createStatement();
		String str2 = "create table author(authorno int(2) primary key, name varchar(50), phone varchar(30))";
		st.execute(str2);
		String str = "create table book(isbn char(8) primary key, title varchar(50) not null, "
				+ "publisher varchar(15) not null, price int not null, description varchar(200), authorno int(2)"
				+ ",foreign key (authorno) references author(authorno))";
//		boolean execute = 
	    st.execute(str);
		System.out.println("테이블 생성");
		st.close();
		con.close();
	}
}
