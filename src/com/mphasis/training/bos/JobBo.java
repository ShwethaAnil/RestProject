package com.mphasis.training.bos;

import java.sql.SQLException;
import java.util.List;

import com.mphasis.training.exceptions.BuisnessException;
import com.mphasis.training.pojos.Job;

public interface JobBo {

	public void addJob(Job j) throws BuisnessException;

	public void editJob(String jcode, String jname) throws BuisnessException;

	public void deleteJob(String jcode) throws BuisnessException;

	public List<Job> getAllJobs() throws BuisnessException;

	public Job getJobById(String jcode) throws BuisnessException, SQLException;
}
