package com.mphasis.training.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mphasis.training.pojos.Employee;
import com.mphasis.training.tos.EmpDepartment;
import com.mphasis.training.util.DbUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	Connection con = null;

	public EmployeeDaoImpl() {
		con = DbUtil.openConnection();
	}

	@Override
	public int addEmployee(Employee e) {
		int i = 0;

		try {
			String query = "insert into employee values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, e.getEmpid());
			pst.setString(2, e.getEname());
			pst.setInt(3, e.getSalary());
			pst.setDate(4, java.sql.Date.valueOf(e.getDoj()));
			pst.setInt(5, e.getBonus());
			pst.setString(6, e.getJcode());
			pst.setInt(7, e.getDeptno());
			pst.setInt(8, e.getMgrno());

			i = pst.executeUpdate();

		} catch (SQLException exp) {
			exp.printStackTrace();
		}

		return i;
	}

	@Override
	public int editEmployee(int empid, int salary) {
		int i = 0;

		try {
			String query = "update employee set salary=? where empid=?";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, salary);
			pst.setInt(2, empid);

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public int deleteEmployee(int empid) {
		int i = 0;

		try {
			String query = "delete from employee where empid=?";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, empid);

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public Employee getEmployeeById(int empid) throws SQLException {
		Employee e = new Employee();
		PreparedStatement pst = null;

		ResultSet rs = null;

		try {
			String query = "select * from employee where empid=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, empid);
			rs = pst.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			if (rs.next()) {
				e.setEmpid(rs.getInt("empid"));
				e.setEname(rs.getString("ename"));
				e.setSalary(rs.getInt("salary"));
				e.setDoj(rs.getDate("doj").toLocalDate());
				e.setBonus(rs.getInt("bonus"));
				e.setJcode(rs.getString("jcode"));
				e.setDeptno(rs.getInt("deptno"));
				e.setMgrno(rs.getInt("mgrno"));
			}

		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			rs.close();
			pst.close();
		}
		return e;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();

		try {
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select * from employee");

			while (rs.next()) {

				Employee e = new Employee();
				e.setEmpid(rs.getInt("empid"));
				e.setEname(rs.getString("ename"));
				e.setSalary(rs.getInt("salary"));
				e.setDoj(rs.getDate("doj").toLocalDate());
				e.setBonus(rs.getInt("bonus"));
				e.setJcode(rs.getString("jcode"));
				e.setDeptno(rs.getInt("deptno"));
				e.setMgrno(rs.getInt("mgrno"));
				employees.add(e);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public List<Employee> retriveEmployeesByJobName(String jname) {
		List<Employee> employees = new ArrayList<>();

		try {
			String query = "select * from employee e join jobs j on e.jcode = j.jcode where j.jname=?";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, jname);

			ResultSet rs = pst.executeQuery();

			/*
			 * if (!rs.isBeforeFirst()) { return null; }
			 */

			while (rs.next()) {

				Employee e = new Employee();
				e.setEmpid(rs.getInt("empid"));
				e.setEname(rs.getString("ename"));
				e.setSalary(rs.getInt("salary"));
				e.setDoj(rs.getDate("doj").toLocalDate());
				e.setBonus(rs.getInt("bonus"));
				e.setJcode(rs.getString("jcode"));
				e.setDeptno(rs.getInt("deptno"));
				e.setMgrno(rs.getInt("mgrno"));
				employees.add(e);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;

	}

	public List<Employee> retriveEmployeesByDeptName(String dname) {
		List<Employee> employees = new ArrayList<>();

		try {
			String query = "select * from employee e join department d on e.deptno = d.deptno where d.dname=?";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, dname);

			ResultSet rs = pst.executeQuery();

			/*
			 * if (!rs.isBeforeFirst()) { return null; }
			 */

			while (rs.next()) {

				Employee e = new Employee();
				e.setEmpid(rs.getInt("empid"));
				e.setEname(rs.getString("ename"));
				e.setSalary(rs.getInt("salary"));
				e.setDoj(rs.getDate("doj").toLocalDate());
				e.setBonus(rs.getInt("bonus"));
				e.setJcode(rs.getString("jcode"));
				e.setDeptno(rs.getInt("deptno"));
				e.setMgrno(rs.getInt("mgrno"));
				employees.add(e);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;

	}

	public List<EmpDepartment> getEmployeeNameAndDepartName(String jname) {
		List<EmpDepartment> employees = new ArrayList<>();
		try {
		String query="select empid,ename, dname, lname from employee e,department d, locations l, jobs j where e.deptno=d.deptno and d.lcode=l.lcode and e.jcode=j.jcode and j.jname=?";
		
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1, jname);
		ResultSet rs=pst.executeQuery();
	
		while(rs.next()) {
			EmpDepartment ed=new EmpDepartment();
			ed.setEmpid(rs.getInt("empid"));
			ed.setEname(rs.getString("ename"));
			ed.setDname(rs.getString("dname"));
			ed.setLname(rs.getString("lname"));
			employees.add(ed);
					}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	
}
