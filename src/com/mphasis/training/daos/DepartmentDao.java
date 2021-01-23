package com.mphasis.training.daos;

import java.sql.SQLException;
import java.util.List;

import com.mphasis.training.pojos.Department;



public interface DepartmentDao {

	public int addDepartment(Department d);

	public int editDepartment(int deptno, String dname);

	public int deleteDepartment(int deptno);

	public Department getDepartmentById(int deptno) throws SQLException;

	public List<Department> getAllDepartments();

}
