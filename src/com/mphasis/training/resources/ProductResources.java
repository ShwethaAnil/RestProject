package com.mphasis.training.resources;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mphasis.training.bos.ProductBo;
import com.mphasis.training.bos.ProductBoImpl;
import com.mphasis.training.exceptions.BuisnessException;
import com.mphasis.training.pojos.Product;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResources {
	
	ProductBo productBo;
	
	public ProductResources() {
		productBo = new ProductBoImpl();
	}

	
	@GET
	@Path("/products")
	public List<Product> getProducts() throws BuisnessException{
		return productBo.getProducts();
	}
	
	//http://localhost:8087/RestProject/admin/products/P123
	//http://localhost:8087/RestProject/admin/products/P124
	@GET
	@Path("/product/{id}")
	public Response getProductById(@PathParam("id") String id) throws  SQLException {
		Product p=null;
		
			try {
			p=productBo.getProductById(id);
			}catch(BuisnessException e) {
				//throw new BuisnessException(e.getMessage());
				return Response.ok().entity(e.getMessage()).build();
			}
		
		return Response.ok().entity(p).build();
	}
	
	
	@POST
	@Path("/product")
	public void addProduct(Product p) throws BuisnessException {
		 productBo.addProduct(p);
	}
	
	
	@DELETE
	@Path("/product/{id}")
	public void  removeProduct(@PathParam("id") String id) throws BuisnessException {
		productBo.removeProduct(id);
	}
	
	@PUT
	@Path("/product/{id}/{cost}/{qty}")
	public void changeProduct(@PathParam("id")String id,@PathParam("cost") double cost,@PathParam("qty") int qty) throws BuisnessException {
		productBo.editProduct(id, cost, qty);
	}
	//http://localhost:8087/RestProject/admin/2021;country=india;author=umesh?bname=Java%20InAction
	
	@GET
	@Path("/{year}")
	public Response getValues(@PathParam("year")String year, @MatrixParam("author")String author,
			@MatrixParam("country")String country, @QueryParam("bname")String bname
			,@HeaderParam("name")String name, @HeaderParam("pwd")String pass) {
		
		return Response.status(200).entity("get books is called in the year "+year+", author "
		+author+" ,country "+country+", Book Name is "+bname+" name is "+name+" password "+pass).build();	
	}
	
	@GET
	@Path("/{someId}/message")
	public SampleResource getSampleResource() {
		return new SampleResource();
	}
	
	
	@GET
	@Path("/ad/myDate")
	public LocalDate getToday() {
		return LocalDate.now();
	}
	
	
	
	
}
