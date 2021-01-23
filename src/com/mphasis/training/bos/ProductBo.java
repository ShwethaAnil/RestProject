package com.mphasis.training.bos;

import java.sql.SQLException;
import java.util.List;

import com.mphasis.training.exceptions.BuisnessException;
import com.mphasis.training.pojos.Product;

public interface ProductBo {

	
		public List<Product> getProducts()throws BuisnessException;
		public Product getProductById(String pid)throws BuisnessException, SQLException;
		public void addProduct(Product p) throws BuisnessException;
		public String getQualityOfProduct(String pid)throws BuisnessException;
		public void editProduct(String pid, double cost,int qty)throws BuisnessException;
		public void removeProduct(String pid)throws BuisnessException;
		public List<Product> sortByPname();
		public List<Product> sortByCost();
		public List<Product> sortByRatings();
		public List<Product> sortByQty();

}
