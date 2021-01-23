package com.mphasis.training.bos;

import java.sql.SQLException;
import java.util.List;

import com.mphasis.training.exceptions.BuisnessException;
import com.mphasis.training.pojos.Department;

public interface DepartmentBo {

	public void addDepartment(Department d) throws BuisnessException;

	public void editDepartment(int deptno, String dname) throws BuisnessException;

	public void deleteDepartment(int deptno) throws BuisnessException;

	public Department getDepartmentById(int deptno) throws BuisnessException, SQLException;

	public List<Department> getAllDepartments() throws BuisnessException;
}
