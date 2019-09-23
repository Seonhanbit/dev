package edu.ssafy.model;

import java.sql.*;
import java.util.*;

public class ProductManager implements IProductManager {
	private Connection conn = null;
	private PreparedStatement st = null;
	private ResultSet rs = null;

	public ProductManager() {
	}

	public boolean addProduct(ProductVO productVO) {
		String str = "insert into products(name, price, description) values(?, ?, ?)";
		int res = 0;
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(str);
			st.setString(1, productVO.getName());
			st.setInt(2, productVO.getPrice());
			st.setString(3, productVO.getDescription());
			res = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return res > 0 ? true : false;
	}

	public ProductVO getProduct(String num) {
		String sql = "select * from products where num=?";
		ProductVO vo = null;
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, num);
			rs = st.executeQuery();
			if (rs.next()) {
				vo = new ProductVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setDescription(rs.getString("description"));
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	public ArrayList<ProductVO> getProductList() {
		String sql = "select * from products";
		ArrayList<ProductVO> list = new ArrayList<>();
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				vo.setDescription(rs.getString("description"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public boolean delProduct(String num) {
		String sql = "delete from products where num=?";
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, num);
			res = st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
