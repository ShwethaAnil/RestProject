package com.mphasis.training.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mphasis.training.pojos.Product;
import com.mphasis.training.util.DbUtil;

public class ProductDaoImpl implements ProductDao {
	
	Connection con=null;
	 public ProductDaoImpl() {
		con=DbUtil.openConnection();
	}

	@Override
	public List<Product> retriveProducts() {
		List<Product> products = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from product");
			while (rs.next()) {
				Product p = new Product();
				p.setPid(rs.getString("pid"));
				p.setPname(rs.getString("pname"));
				p.setQty(rs.getInt("qty"));
				p.setCost(rs.getDouble("cost"));
				p.setRatings(rs.getDouble("ratings"));
				products.add(p);
			}
		} catch (SQLException e) {
		e.printStackTrace();
	}
		return products;
	}

	@Override
	public int addProduct(Product p) {
		int i=0;
		try {
			String query="insert into product values(?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,p.getPid());
			pst.setString(2, p.getPname());
			pst.setInt(3, p.getQty());
			pst.setDouble(4, p.getCost());
			pst.setDouble(5, p.getRatings());
			
			i=pst.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateProduct(String pid, double cost, int qty) {
		int i=0;
		try {
			String query="update product set cost=? , qty=? where pid=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setDouble(1, cost);
			pst.setInt(2, qty);
			pst.setString(3, pid);
			i=pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteProduct(String pid) {
		int i=0;
		try {
			String query="delete from product where pid=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, pid);
			i=pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Product retiveProductById(String pid) throws SQLException {
		Product p=new Product();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			String query="select * from product where pid=?";
			 pst=con.prepareStatement(query);
			 pst.setString(1, pid);
			 rs=pst.executeQuery();
			if(rs.next()) {
				p.setPid(rs.getString("pid"));
				p.setPname(rs.getString("pname"));
				p.setQty(rs.getInt("qty"));
				p.setCost(rs.getDouble("cost"));
				p.setRatings(rs.getDouble("ratings"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			rs.close();
			pst.close();
		}
		
		return p;
	}

}
