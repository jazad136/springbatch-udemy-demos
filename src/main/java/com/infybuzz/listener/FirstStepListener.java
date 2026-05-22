package com.infybuzz.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class FirstStepListener implements StepExecutionListener{
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		System.err.println("Before Step " + stepExecution.getStepName());
		System.err.println("Job Exec Cont " + stepExecution.getJobExecution().getExecutionContext());
		System.err.println("Step Exec Cont " + stepExecution.getExecutionContext());
		
		stepExecution.getExecutionContext().put("sec", "sec value");
	}
	
	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.err.println("After Step " + stepExecution.getStepName());
		System.err.println("Job Exec Cont " + stepExecution.getJobExecution().getExecutionContext());
		System.err.println("Step Exec Cont " + stepExecution.getExecutionContext());
		return null;
	}
}
