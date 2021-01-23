package com.mphasis.training.bos;

import java.sql.SQLException;
import java.util.List;

import com.mphasis.training.daos.EmployeeDao;
import com.mphasis.training.daos.EmployeeDaoImpl;
import com.mphasis.training.exceptions.BuisnessException;
import com.mphasis.training.exceptions.DataNotPresentException;
import com.mphasis.training.pojos.Employee;
import com.mphasis.training.tos.EmpDepartment;

public class EmployeeBoImpl implements EmployeeBo {

	EmployeeDao employeeDao = null;

	public EmployeeBoImpl() {
		employeeDao = new EmployeeDaoImpl();
	}

	@Override
	public void addEmployee(Employee e) throws BuisnessException, SQLException {

		if (e.getEmpid() > 0 && employeeDao.getEmployeeById(e.getEmpid()).getEmpid() <0) {
			if (!e.getEname().isEmpty() && e.getEname().matches("[A-Z]+")) {
				if (e.getSalary() > 0) {
					if (e.getBonus() > 0) {
						if (e.getDeptno() > 0) {
							if (!e.getJcode().isEmpty()) {
								if (e.getMgrno() > 0) {
									employeeDao.addEmployee(e);
								} else {
									throw new BuisnessException("Invalid data");
								}
							} else {
								throw new BuisnessException("Invalid data");
							}
						} else {
							throw new BuisnessException("Invalid data");
						}
					} else {
						throw new BuisnessException("Invalid data");
					}
				} else {
					throw new BuisnessException("Invalid data");
				}
			} else {
				throw new BuisnessException("Invalid data");
			}
		} else {
			throw new BuisnessException("Invalid Id or Id is already Exists");
		}

	}

	@Override
	public void editEmployee(int empid, int salary) throws BuisnessException {

		if (empid > 0) {
			if (salary > 0) {
				employeeDao.editEmployee(empid, salary);
			} else {
				throw new BuisnessException("Cost should be grater than 0");
			}
		} else {
			throw new BuisnessException("Salary should be grater than 0");
		}

	}

	@Override
	public void deleteEmployee(int empid) throws BuisnessException {

		if (empid > 0) {
			employeeDao.deleteEmployee(empid);
		} else {
			throw new BuisnessException("empid should be greater than zero.");
		}

	}

	@Override
	public List<Employee> getAllEmployees() throws BuisnessException {
		List<Employee> employees = employeeDao.getAllEmployees();
		if (employees.isEmpty()) {
			throw new BuisnessException("No Employees in the list");
		}
		return employees;
	}

	@Override
	public Employee getEmployeeById(int empid) throws DataNotPresentException, SQLException {
		Employee e = employeeDao.getEmployeeById(empid);
		if (e.getEmpid() == 0) {
			throw new DataNotPresentException("Requested Employee is not present");
		}
		return e;
	}

	public List<Employee> retriveEmployeesByJobName(String jname) throws BuisnessException {
		List<Employee> employees = employeeDao.retriveEmployeesByJobName(jname);
		if (employees.isEmpty()) {
			throw new BuisnessException("No Employees in the list");
		}
		return employees;
	}

	public List<Employee> retriveEmployeesByDeptName(String dname) throws BuisnessException {
		List<Employee> employees = employeeDao.retriveEmployeesByDeptName(dname);
		if (employees.isEmpty()) {
			throw new BuisnessException("No Employees in the list");
		}
		return employees;
	}

	@Override
	public List<EmpDepartment> getEmployeeNameAndDepartName(String jname) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeNameAndDepartName(jname);
	}

}
