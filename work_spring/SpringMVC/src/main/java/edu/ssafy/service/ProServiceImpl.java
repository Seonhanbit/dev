package edu.ssafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.dto.Product;
import edu.ssafy.repository.ProRepo;

@Service(value = "ProServiceImpl")
public class ProServiceImpl implements ProService{

	@Autowired
	@Qualifier("ProMybatisImpl")
	private ProRepo repo;
	
	public ProServiceImpl() {}
	
	@Override
	public void insert(Product p) {
		repo.insert(p);		
	}

	@Override
	public void update(Product p) {
		repo.update(p);	
	}

	@Override
	public void delete(String num) {
		repo.delete(num);		
	}

	@Override
	public Product selectOne(String num) {
		return repo.selectOne(num);
	}

	@Override
	public List<Product> selectList() {
		return repo.selectList();
	}

}
