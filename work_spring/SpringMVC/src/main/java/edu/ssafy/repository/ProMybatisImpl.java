package edu.ssafy.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.Product;

@Repository("ProMybatisImpl")
public class ProMybatisImpl implements ProRepo{

	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(Product p) {
		session.insert("sql.pro.insertPro",p);		
	}

	@Override
	public void update(Product p) {
		session.update("sql.pro.updatePro",p);		
	}

	@Override
	public void delete(String num) {
		session.delete("sql.pro.deletePro", num);
	}

	@Override
	public Product selectOne(String num) {
		return session.selectOne("sql.pro.selectPro", num);
	}

	@Override
	public List<Product> selectList() {
		return session.selectList("sql.pro.selectPros");
	}

}
