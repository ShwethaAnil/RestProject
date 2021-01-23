package com.mphasis.training.daos;

import java.sql.SQLException;
import java.util.List;

import com.mphasis.training.pojos.Product;

public interface ProductDao {
	
	public List<Product> retriveProducts();
	public int addProduct(Product p);
	public int updateProduct(String pid, double cost, int qty);
	public int deleteProduct(String pid);
	public Product retiveProductById(String pid)throws SQLException;
}
