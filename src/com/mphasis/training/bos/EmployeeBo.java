package com.mphasis.training.bos;

import java.sql.SQLException;
import java.util.List;

import com.mphasis.training.exceptions.BuisnessException;
import com.mphasis.training.exceptions.DataNotPresentException;
import com.mphasis.training.pojos.Employee;
import com.mphasis.training.tos.EmpDepartment;

public interface EmployeeBo {

	public void addEmployee(Employee e) throws BuisnessException, SQLException;

	public void editEmployee(int empid, int salary) throws BuisnessException;

	public void deleteEmployee(int empid) throws BuisnessException;

	public List<Employee> getAllEmployees() throws BuisnessException;

	public Employee getEmployeeById(int empid) throws DataNotPresentException, SQLException;

	public List<Employee> retriveEmployeesByJobName(String jname) throws BuisnessException, SQLException;;

	public List<Employee> retriveEmployeesByDeptName(String dname) throws BuisnessException, SQLException;;
	public List<EmpDepartment> getEmployeeNameAndDepartName(String jname);
}
