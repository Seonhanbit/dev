package edu.ssafy.service;

import java.util.List;

import edu.ssafy.dto.Product;

public interface ProService {
	public void insert(Product p);
	public void update(Product p);
	public void delete(String num);
	public Product selectOne(String num);
	public List<Product> selectList();	
}
