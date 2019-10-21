package edu.ssafy.Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.ssafy.model.ConnectionProxy;

public class VisitCount {

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public void VisitCounting(String datetime) {

		String query = "insert into visiting(present) values(?);";

		try {
			con = ConnectionProxy.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, datetime);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Visit Counting Failed...");
		} finally {
			close();
		}
	}
	
	public int Visited() {
		
		String query = "select num from visiting order by num desc limit 1";
		int num = 0;
		
		try {
			con = ConnectionProxy.getConnection();
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt("num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Visited Print Failed...");
		} finally {
			close();
		}
		
		return num;
	}
	
	public void close() {

		try {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("closed failed...");
		}
	}
}
