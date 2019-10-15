package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.model.dto.Product;
import com.ssafy.model.repository.ProductRepo;
import com.ssafy.model.repository.ProductRepoImpl;

@Component("service")
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepo repo;
	@Override
	public ProductRepo getRepo() {
		return repo;
	}

	@Override
	public List<Product> selectAll() {
		List<Product> list = getRepo().selectAll();
		return list;
	}

	@Override
	public Product select(String id) {
		Product pro = repo.select(id);
		return pro;
	}

	@Override
	public int insert(Product product) {
		int a = repo.insert(product);
		return a;
	}

	@Override
	public int update(Product product) {
		int a = repo.update(product);
		return a;
	}

	@Override
	public int delete(String id) {
		int a = repo.delete(id);
		return a;
	}

}
