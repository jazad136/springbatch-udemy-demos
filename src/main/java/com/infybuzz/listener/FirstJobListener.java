package com.infybuzz.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class FirstJobListener implements JobExecutionListener{
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.err.println("Before Job " + jobExecution.getJobInstance().getJobName());
		System.err.println("Job Params " + jobExecution.getJobParameters());
		System.err.println("Job Exec Context " + jobExecution.getExecutionContext());
//		JobExecutionListener.super.beforeJob(jobExecution);
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		System.err.println("After Job " + jobExecution.getJobInstance().getJobName());
		System.err.println("Job Params " + jobExecution.getJobParameters());
		System.err.println("Job Exec Context " + jobExecution.getExecutionContext());
//		JobExecutionListener.super.afterJob(jobExecution);
	}
}
