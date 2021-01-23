package com.mphasis.training.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mphasis.training.pojos.Department;
import com.mphasis.training.util.DbUtil;

public class DepartmentDaoImpl implements DepartmentDao {

	Connection con = null;

	public DepartmentDaoImpl() {
		con = DbUtil.openConnection();
	}

	@Override
	public int addDepartment(Department d) {
		int i = 0;

		try {
			String query = "insert into department values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, d.getDeptno());
			pst.setString(2, d.getDname());
			pst.setInt(3, d.getLcode());

			i = pst.executeUpdate();

			pst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public int editDepartment(int deptno, String dname) {
		int i = 0;

		try {
			String query = "update department set dname=? where deptno=?";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, dname);
			pst.setInt(2, deptno);

			i = pst.executeUpdate();

			pst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public int deleteDepartment(int deptno) {
		int i = 0;

		try {
			String query = "delete from department where deptno=?";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, deptno);

			i = pst.executeUpdate();

			pst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public Department getDepartmentById(int deptno) throws SQLException {
		Department d = new Department();
		PreparedStatement pst = null;

		ResultSet rs = null;

		try {
			String query = "select * from department where deptno=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, deptno);
			rs = pst.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			if (rs.next()) {
				d.setDeptno(rs.getInt("deptno"));
				d.setDname(rs.getString("dname"));
				d.setLcode(rs.getInt("lcode"));
			}

		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			rs.close();
			pst.close();
		}
		return d;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departments = new ArrayList<>();

		try {
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select * from department");

			while (rs.next()) {

				Department d = new Department();
				d.setDeptno(rs.getInt("deptno"));
				d.setDname(rs.getString("dname"));
				d.setLcode(rs.getInt("lcode"));

				departments.add(d);

			}

			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departments;
	}

}
