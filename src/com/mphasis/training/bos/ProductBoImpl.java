package com.mphasis.training.bos;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.mphasis.training.daos.ProductDao;
import com.mphasis.training.daos.ProductDaoImpl;
import com.mphasis.training.exceptions.BuisnessException;
import com.mphasis.training.pojos.Product;

public class ProductBoImpl implements ProductBo {
	ProductDao productDao = null;

	public ProductBoImpl() {
		productDao = new ProductDaoImpl();
	}

	@Override
	public List<Product> getProducts() throws BuisnessException {
		List<Product> products = productDao.retriveProducts();
		if (products.isEmpty()) {
			throw new BuisnessException("No Products in the list");
		}
		return products;

	}

	@Override
	public Product getProductById(String pid) throws BuisnessException,SQLException {
		Product p = productDao.retiveProductById(pid);
		if (p.getPid() == null) {
			throw new BuisnessException("Pid is not present");
		}
		return p;
	}

	@Override
	public void addProduct(Product p) throws BuisnessException {
		if (p.getPid().matches("[P][0-9]{3}")) {
			if (p.getPname().matches("[a-zA-Z0-9]{3,15}")) {
				if (p.getQty() > 0) {
					if (p.getCost() > 0) {
						if (p.getRatings() < 5 && p.getRatings() > 0) {
							productDao.addProduct(p);
							// System.out.println("Product added at index "+index);
						} else {
							throw new BuisnessException("ratings with in 5");
						}
					} else {
						throw new BuisnessException("cost accepts only postive number");
					}
				} else {
					throw new BuisnessException("qty accepts only positive number");
				}
			} else {
				throw new BuisnessException("Pname should contains only letters length 3 to 15");
			}
		} else {
			throw new BuisnessException("pid should start with P and 3 digits");
		}

	}

	@Override
	public String getQualityOfProduct(String pid) throws BuisnessException {
		String quality = null;
		Product p;
		try {
			p = productDao.retiveProductById(pid);
			if (p.getRatings() >= 4.5 && p.getRatings() <= 5) {
				quality = "very good";
			} else if (p.getRatings() < 4.5 && p.getRatings() >= 4) {
				quality = "good";
			} else if (p.getRatings() < 4 && p.getRatings() > 3.5) {
				quality = "Ok Ok";
			} else if (p.getRatings() <= 3.5 && p.getRatings() > 2.5) {
				quality = "bad";
			} else if (p.getRatings() < 2.5) {
				quality = "very bad";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return quality;
	}

	@Override
	public void editProduct(String pid, double cost, int qty) throws BuisnessException {
		if (pid.matches("[P][0-9]{3}")) {
			if (cost > 0) {
				productDao.updateProduct(pid, cost, qty);
			} else {
				throw new BuisnessException("Cost should be grater than 0");
			}
		} else {
			throw new BuisnessException("Pid should start with P and 3 digits");
		}

	}

	@Override
	public void removeProduct(String pid) throws BuisnessException {
		if (pid.matches("[P][0-9]{3}")) {
			productDao.deleteProduct(pid);
		} else {
			throw new BuisnessException("Pid should start with P and 3 digits");
		}

	}

	@Override
	public List<Product> sortByPname() {
		List<Product> products=productDao.retriveProducts();
		Collections.sort(products, (p1,p2)-> p1.getPname().compareTo(p2.getPname()));
		return products;
	}

	@Override
	public List<Product> sortByCost() {
		List<Product> products=productDao.retriveProducts();
		Collections.sort(products, (p1,p2)-> (int)(p1.getCost() - p2.getCost()));
		return products;

	}

	@Override
	public List<Product> sortByRatings() {
		List<Product> products=productDao.retriveProducts();
		Collections.sort(products, (p1,p2)-> (int)(p1.getRatings() - p2.getRatings()));
		return products;
	}

	@Override
	public List<Product> sortByQty() {
		List<Product> products=productDao.retriveProducts();
		Collections.sort(products, (p1,p2)-> p1.getQty()- p2.getQty());
		return products;
	}

}
