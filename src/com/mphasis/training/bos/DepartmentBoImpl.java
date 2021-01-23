package com.mphasis.training.bos;

import java.sql.SQLException;
import java.util.List;

import com.mphasis.training.daos.DepartmentDao;
import com.mphasis.training.daos.DepartmentDaoImpl;
import com.mphasis.training.exceptions.BuisnessException;
import com.mphasis.training.pojos.Department;

public class DepartmentBoImpl implements DepartmentBo {

	DepartmentDao departmentDao = null;

	public DepartmentBoImpl() {
		departmentDao = new DepartmentDaoImpl();
	}

	@Override
	public void addDepartment(Department d) throws BuisnessException {
		if ((d.getLcode() + "").matches("^[1-9][0-9]{2}[0-9]*")) {
			if (d.getDeptno() > 0) {
				int i = departmentDao.addDepartment(d);

				if (i > 0) {
					System.out.println(i + " row added.");
				} else
					System.out.println("no row added.");

			} else
				throw new BuisnessException("Dept. no. wrong format.");
		} else
			throw new BuisnessException("Lcode wrong format.");
	}

	@Override
	public void editDepartment(int deptno, String dname) throws BuisnessException {

		if (deptno > 0) {
			int i = departmentDao.editDepartment(deptno, dname);
			if (i > 0) {
				System.out.println(i + " row updated.");
			} else
				System.out.println("no row updated.");
		} else {
			throw new BuisnessException("deptno wrong format.");
		}

	}

	@Override
	public void deleteDepartment(int deptno) throws BuisnessException {

		if (deptno > 0) {
			int i = departmentDao.deleteDepartment(deptno);

			if (i > 0) {
				System.out.println(i + " deleted.");
			} else
				System.out.println("no row deleted.");

		} else {
			throw new BuisnessException("deptno wrong format.");
		}

	}

	@Override
	public List<Department> getAllDepartments() throws BuisnessException {
		List<Department> departments = departmentDao.getAllDepartments();
		if (departments.isEmpty()) {
			throw new BuisnessException("No Departments in the list");
		}
		return departments;
	}

	@Override
	public Department getDepartmentById(int deptno) throws BuisnessException, SQLException {
		Department l;

		if (deptno > 0) {
			l = departmentDao.getDepartmentById(deptno);
		} else
			throw new BuisnessException("deptno wrong format.");

		if (l == null) {
			throw new BuisnessException("department code doesnt exist.");
		}
		return l;
	}

}
