package com.ssafy.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ssafy.model.dto.Product;
import com.ssafy.test.ConnectionProxy;

@Component("repo")
public class ProductRepoImpl implements ProductRepo {

	public ProductRepoImpl() {
	}

	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;

	@Override
	public List<Product> selectAll() {
		String sql = "select * from product";
		List<Product> list = null;
		try {
			conn = ConnectionProxy.getConnection();

			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			list = new ArrayList<Product>();
			while (rs.next()) {
				Product pro = new Product();
				pro.setId(rs.getString("id"));
				pro.setName(rs.getString("name"));
				pro.setPrice(rs.getInt("price"));
				pro.setDescription(rs.getString("description"));
				list.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public Product select(String id) {
		String sql = "select * from product where id = ?";
		Product pro = null;
		try {
			conn = ConnectionProxy.getConnection();

			st = conn.prepareStatement(sql);
			st.setString(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				pro = new Product();
				pro.setId(rs.getString("id"));
				pro.setName(rs.getString("name"));
				pro.setPrice(rs.getInt("price"));
				pro.setDescription(rs.getString("description"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return pro;
	}

	@Override
	public int insert(Product product) {
		String str = "insert into product(id,name,price,description)values(?,?,?,?)";
		int a = 1;
		try {
			conn = ConnectionProxy.getConnection();

			st = conn.prepareStatement(str);
			st.setString(1, product.getId());
			st.setString(2, product.getName());
			st.setInt(3, product.getPrice());
			st.setString(4, product.getDescription());
			st.execute();
			a = 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			a = 1;
		} finally {
			close();
		}
		return a;
	}

	@Override
	public int update(Product product) {
		String str = "update product set name = ?, price = ?,description = ? where id = ?";
		int a = 1;
		try {
			conn = ConnectionProxy.getConnection();

			st = conn.prepareStatement(str);
			st.setString(1, product.getName());
			st.setInt(2, product.getPrice());
			st.setString(3, product.getDescription());
			st.setString(4, product.getId());
			st.executeUpdate();
			a = 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			a = 1;
		} finally {
			close();
		}
		return a;
	}

	@Override
	public int delete(String id) {
		String str = "delete from product where id = ?";
		int a = 1;
		try {
			conn = ConnectionProxy.getConnection();

			st = conn.prepareStatement(str);
			st.setString(1, id);
			st.execute();
			a = 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			a = 1;
		} finally {
			close();
		}
		return a;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
