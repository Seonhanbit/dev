package edu.ssafy.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IProductManager {
	public boolean addProduct(ProductVO productVO);

	public ProductVO getProduct(String num);

	public ArrayList<ProductVO> getProductList();

	public boolean delProduct(String num);

	public void close();
}
