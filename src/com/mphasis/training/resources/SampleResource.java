package com.mphasis.training.resources;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mphasis.training.pojos.Product;

@Path("/")
public class SampleResource {
	
	List<Product> products=new ArrayList<Product>();
	
	
	@GET
	public String getMessage() {
		System.out.println("Called");
		return "Hello";
	}
	
	@GET
	@Path("/{messageId}")
	public String getMessage1(@PathParam("messageId") String mid) {
		System.out.println("Called");
		return "Hello "+mid;
	}
	
	@GET
	@Path("/myDate/{year}/{month}/{date}")
	public String getDate(@PathParam("year") int year,@PathParam("month")int month,@PathParam("date")int date) {
		System.out.println("Called"+date);
		LocalDate ld=LocalDate.of(year, month, date);
		return "Hello "+date;
	}
	
	
	
	
	
//	@GET
//	@Path("/product")
//	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//	public Product getProduct() {
//		return new Product("P123","Watch",3456,456789,4.5);
//	}
//	
//	@GET
//	@Path("/products")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Product> getProducts() {
//		products.add(new Product("P123","Watch",3456,456789,4.5));
//		products.add(new Product("P124","Watch",3456,456789,4.5));
//		products.add(new Product("P125","Watch",3456,456789,4.5));
//		products.add(new Product("P126","Watch",3456,456789,4.5));
//		return products;
//	}
//	
//	@POST
//	@Path("/product")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Product> addProduct(Product p) {
//		products.add(new Product("P123","Watch",3456,456789,4.5));
//		products.add(new Product("P124","Watch",3456,456789,4.5));
//		products.add(new Product("P125","Watch",3456,456789,4.5));
//		products.add(new Product("P126","Watch",3456,456789,4.5));
//		products.add(p);
//		return products;
//	}

}
