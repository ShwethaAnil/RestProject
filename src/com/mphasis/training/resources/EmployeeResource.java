package com.mphasis.training.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mphasis.training.bos.EmployeeBo;
import com.mphasis.training.bos.EmployeeBoImpl;
import com.mphasis.training.exceptions.BuisnessException;
import com.mphasis.training.exceptions.DataNotPresentException;

import com.mphasis.training.pojos.Employee;
import com.mphasis.training.tos.EmpDepartment;

@Path("/emp")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {
	
	EmployeeBo employeeBo;
	
	public EmployeeResource() {
		employeeBo=new EmployeeBoImpl();
	}
	
	@GET
	public List<Employee> getEmployees() throws BuisnessException{
		return employeeBo.getAllEmployees();
	}
	
	@GET
	@Path("/{eid}")
	public Response getEmployeeById(@PathParam("eid")int eid) {
		Employee emp=null;
		try {
			 emp=employeeBo.getEmployeeById(eid);
		} catch (Exception e) {
			throw new DataNotPresentException("Requested Employee is not present");
		} 
		return Response.ok().entity(emp).build();
	}
	
	
	@GET
	@Path("/aemp/{jname}")
	public Response getEmployeeById(@PathParam("jname")String jname) {
		List<EmpDepartment> employees=null;
		try {
			 employees=employeeBo.getEmployeeNameAndDepartName(jname);
			 System.out.println(employees);
		} catch (Exception e) {
			throw new DataNotPresentException("Requested Jname is not present");
		} 
		return Response.ok().entity(employees).build();
	}
	
	@POST
	public Response addEmployee(Employee employee) throws URISyntaxException {
		
		try {
			employeeBo.addEmployee(employee);
		} catch (BuisnessException e) {
			throw new DataNotPresentException(e.getMessage());
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return Response.created(new URI("/RestProject/emp/"+employee.getEmpid())).entity(employee).build();
	}
	
	

}
