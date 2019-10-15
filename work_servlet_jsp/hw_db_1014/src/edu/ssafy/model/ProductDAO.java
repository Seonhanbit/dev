package edu.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ssafy.model.DBCPConnection;

public class ProductDAO {
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	List<Product> list = new ArrayList<>();

	public boolean InsertPro(String pno, String pname, int pprice) {
		String query = "insert into product values(?,?,?)";
		boolean res = false;
		try {
			con = DBCPConnection.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, pno);
			pst.setString(2, pname);
			pst.setInt(3, pprice);
			res = pst.execute();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = false;
		} finally {
			DBCPConnection.close(con, pst);
		}
		return res;
	}

	public List<Product> searchAll() {
		String query = "select * from product";
		List<Product> list = null;
		try {
			con = DBCPConnection.getConnection();
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				Product p = new Product();
				p.setPno(rs.getString("pno"));
				p.setPname(rs.getString("pname"));
				p.setPprice(rs.getInt("pprice"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCPConnection.close(con, pst, rs);
		}
		return list;
	}
}
