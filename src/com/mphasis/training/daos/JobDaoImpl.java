package com.mphasis.training.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mphasis.training.pojos.Job;
import com.mphasis.training.util.DbUtil;

public class JobDaoImpl implements JobDao {

	Connection con = null;

	public JobDaoImpl() {
		con = DbUtil.openConnection();
	}

	@Override
	public int addJob(Job j) {
		int i = 0;

		try {
			String query = "insert into jobs values(?,?)";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, j.getJcode());
			pst.setString(2, j.getJname());

			i = pst.executeUpdate();

			pst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	public int editJob(String jcode, String jname) {
		int i = 0;

		try {
			String query = "update jobs set jname=? where jcode=?";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, jname);
			pst.setString(2, jcode);

			i = pst.executeUpdate();

			pst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	public int deleteJob(String jcode) {
		int i = 0;

		try {
			String query = "delete from jobs where jcode=?";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, jcode);

			i = pst.executeUpdate();

			pst.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	public Job getJobById(String jcode) throws SQLException {
		Job j = new Job();
		PreparedStatement pst = null;

		ResultSet rs = null;

		try {
			String query = "select * from jobs where jcode=?";
			pst = con.prepareStatement(query);
			pst.setString(1, jcode);
			rs = pst.executeQuery();

			if (!rs.isBeforeFirst()) {
				return null;
			}

			if (rs.next()) {
				j.setJcode(rs.getString("jcode"));
				j.setJname(rs.getString("jname"));
			}

		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			rs.close();
			pst.close();
		}
		return j;
	}

	public List<Job> getAllJobs() {
		List<Job> jobs = new ArrayList<>();

		try {
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select * from jobs");

			while (rs.next()) {

				Job j = new Job();
				j.setJcode(rs.getString("jcode"));
				j.setJname(rs.getString("jname"));

				jobs.add(j);

			}

			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobs;
	}
}
