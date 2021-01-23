package com.mphasis.training.daos;

import java.sql.SQLException;
import java.util.List;

import com.mphasis.training.pojos.Employee;
import com.mphasis.training.tos.EmpDepartment;

public interface EmployeeDao {

	public int addEmployee(Employee e);

	public int editEmployee(int empid, int salary);

	public int deleteEmployee(int empid);

	public Employee getEmployeeById(int empid) throws SQLException;

	public List<Employee> getAllEmployees();

	public List<Employee> retriveEmployeesByJobName(String jname);

	public List<Employee> retriveEmployeesByDeptName(String dname);
	
	public List<EmpDepartment> getEmployeeNameAndDepartName(String jname);

}
