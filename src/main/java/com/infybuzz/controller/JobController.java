package com.infybuzz.controller;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infybuzz.service.JobService;

@RestController
@RequestMapping("/api/job")
public class JobController {
	
	@Autowired
	JobService jobService; 
	
	@GetMapping("/ping")
	public String ping() { 
		return "Hello World.";
	}
	
	@GetMapping("/start/{jobName}")
	public String startJob(@PathVariable String jobName) 
			throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		jobService.startJob(jobName);
		return "Job started...";
	}
}
