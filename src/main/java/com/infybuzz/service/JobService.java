package com.infybuzz.service;

import java.util.HashMap;
import java.util.List;
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

import com.infybuzz.model.JobParamsRequest;

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
	public void startJob(String jobName, List<JobParamsRequest> jobParamsRequestList) {
		Map<String, JobParameter<?>> params = new HashMap<>();
		
		params.put("currentTime",new JobParameter<Long>(System.currentTimeMillis(),Long.class));
		jobParamsRequestList.stream().forEach(jobParamsReq -> 
			params.put(jobParamsReq.paramKey, new JobParameter<String>(jobParamsReq.paramValue, String.class))
		);
		JobParameters jobParameters = new JobParameters(params);
		try {
			JobExecution jobExecution = null;
			if(jobName.equals("First Job")) { 
				jobExecution = jobLauncher.run(firstJob, jobParameters);
			}
			else if(jobName.equals("Second Job")) {
				jobExecution = jobLauncher.run(secondJob, jobParameters);
			}
			if(jobExecution == null) 
				System.err.println("No job started.");
			else
				System.err.println("Job Execution ID = " + jobExecution.getId());
		} catch(Exception e) {
			logger.debug("Exception while starting job", e);
		}
		
	}
}
