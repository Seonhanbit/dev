package edu.ssafy.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBCPConnection {
	private static DataSource env;
	static {
		try {
			// tomcat > context.xml에 있는 DataSource 타입이 나옴
			// lookup 이름을 가지고 찾음  name="ssafy/mysql"
			InitialContext initialContext = new InitialContext();
			env = (DataSource) initialContext.lookup("java:comp/env/ssafy/mysql");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		if (env != null) {
			Connection conn = env.getConnection();
			if (conn != null) {
				System.out.println("Connection Success");
			}
			return conn;
		} else {
			System.out.println("Connection Fail");
			return null;
		}
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection conn, Statement stmt) {
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
