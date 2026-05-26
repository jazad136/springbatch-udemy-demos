package com.infybuzz.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class JobService {

	private static final Logger logger = LoggerFactory.getLogger(JobService.class);
	@Autowired
	JobLauncher jobLauncher;

	@Qualifier("firstJob")
	@Autowired
	Job firstJob;

	@Qualifier("secondJob")
	@Autowired
	Job secondJob;

	@Async
	public void startJob(String jobName) {
		Map<String, JobParameter<?>> params = new HashMap<>();
		
		params.put("currentTime",
				new JobParameter<Long>(
					System.currentTimeMillis(),
					Long.class
				));
		JobParameters jobParameters = new JobParameters(params);
		try {
			JobExecution jobExecution = null;
			if(jobName.equals("First Job")) { 
				jobExecution = jobLauncher.run(firstJob, jobParameters);
//				return "Job started...";
			}
			else if(jobName.equals("Second Job")) {
				jobExecution = jobLauncher.run(secondJob, jobParameters);
//				return "Job started...";		
			}
			// we're going multithreaded so I prefer to start using loggers instead.
			// we updated application.properties accordingly
			logger.warn("Job Execution ID = " + jobExecution.getId());
//			System.err.println("Job Execution ID = " + jobExecution.getId());
		} catch(Exception e) {
			logger.warn("Exception while starting job");
//			System.out.println("Exception while starting job");
		}
//		return "No job started.";
	}
}
