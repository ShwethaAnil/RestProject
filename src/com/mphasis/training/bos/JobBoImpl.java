package com.mphasis.training.bos;

import java.sql.SQLException;
import java.util.List;

import com.mphasis.training.daos.JobDao;
import com.mphasis.training.daos.JobDaoImpl;
import com.mphasis.training.exceptions.BuisnessException;
import com.mphasis.training.pojos.Job;

public class JobBoImpl implements JobBo {

	JobDao jobDao = null;

	public JobBoImpl() {
		jobDao = new JobDaoImpl();
	}

	@Override
	public void addJob(Job j) throws BuisnessException {

		if (j.getJcode().startsWith("J") || j.getJcode().startsWith("j")) {
			int i = jobDao.addJob(j);

			if (i > 0) {
				System.out.println(i + " row added.");
			} else
				System.out.println("no row added.");

		} else
			throw new BuisnessException("Jcode wrong format.");

	}

	@Override
	public void editJob(String jcode, String jname) throws BuisnessException {

		if (jcode.startsWith("J") || jcode.startsWith("j")) {
			int i = jobDao.editJob(jcode, jname);
			if (i > 0) {
				System.out.println(i + " row updated.");
			} else
				System.out.println("no row updated.");
		} else {
			throw new BuisnessException("Jcode wrong format.");
		}

	}

	@Override
	public void deleteJob(String jcode) throws BuisnessException {

		if (jcode.startsWith("J") || jcode.startsWith("j")) {
			int i = jobDao.deleteJob(jcode);

			if (i > 0) {
				System.out.println(i + " deleted.");
			} else
				System.out.println("no row deleted.");

		} else {
			throw new BuisnessException("Jcode wrong format.");
		}

	}

	@Override
	public List<Job> getAllJobs() throws BuisnessException {
		List<Job> jobs = jobDao.getAllJobs();
		if (jobs.isEmpty()) {
			throw new BuisnessException("No Jobs in the list");
		}
		return jobs;
	}

	@Override
	public Job getJobById(String jcode) throws BuisnessException, SQLException {
		Job j;

		if (jcode.startsWith("J") || jcode.startsWith("j")) {
			j = jobDao.getJobById(jcode);
		} else
			throw new BuisnessException("Jcode wrong format.");

		if (j == null) {
			throw new BuisnessException("job code doesnt exist.");
		}
		return j;
	}

}
