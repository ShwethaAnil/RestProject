package com.mphasis.training.daos;

import java.sql.SQLException;
import java.util.List;

import com.mphasis.training.pojos.Job;
import com.mphasis.training.util.DbUtil;

public interface JobDao {

	public int addJob(Job j);

	public int editJob(String jcode, String jname);

	public int deleteJob(String jcode);

	public Job getJobById(String jcode) throws SQLException;

	public List<Job> getAllJobs();

}
