package edu.ssafy.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.Member;
import edu.ssafy.dto.Product;

@Repository("ProImpl")
public class ProImpl implements ProRepo {

	@Autowired
	private DataSource ds;
	
	public ProImpl() {}
	
	@Override
	public void insert(Product p) {
		System.out.println("insert");
		Connection conn=null;
		PreparedStatement pstmt = null;
		try {
			conn=ds.getConnection();
			pstmt = conn.prepareStatement("insert into pros(num,name,price) values(?,?,?)");
			pstmt.setString(1, p.getNum());
			pstmt.setString(2, p.getName());
			pstmt.setString(3, p.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void update(Product p) {
		System.out.println("update");
		Connection conn=null;
		PreparedStatement pstmt = null;
		try {
			conn=ds.getConnection();
			pstmt = conn.prepareStatement("update pros set name=?,price=? where num=?");
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getPrice());
			pstmt.setString(3, p.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(String num) {
		System.out.println("delete");
		Connection conn=null;
		PreparedStatement pstmt = null;
		try {
			conn=ds.getConnection();
			pstmt = conn.prepareStatement("delete from pros where num=?");
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Product selectOne(String num) {
		System.out.println("selectOne");
		Connection conn=null;
		PreparedStatement pstmt = null;
		Product p = null;
		try {
			conn=ds.getConnection();
			pstmt = conn.prepareStatement("select num, name, price from pros where num = ?");
			pstmt.setString(1, num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				p = new Product(rs.getString("num"),rs.getString("name"),rs.getString("price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}

	@Override
	public List<Product> selectList() {
		System.out.println("selectList");
		Connection conn=null;
		PreparedStatement pstmt = null;
		Product p = null;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			conn=ds.getConnection();
			pstmt = conn.prepareStatement("select num, name, price from pros");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				p = new Product(rs.getString("num"),rs.getString("name"),rs.getString("price"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

}
