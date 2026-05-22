package com.infybuzz.service;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Service;

@Service
public class SecondTasklet implements Tasklet {
	public RepeatStatus execute(StepContribution contribution, ChunkContext context) { 
  		System.err.println("This is second tasklet step");
  		System.err.println(context.getStepContext().getJobExecutionContext());
  		return RepeatStatus.FINISHED;
  	}
}
