package com.rk.listener;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component("jmListener")
public class JobMonitoringListener implements JobExecutionListener {
	private long start,end;
	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("JobMonitoringListener.beforeJob()");
		System.out.println("Job started at::"+new Date());
		start=System.currentTimeMillis();
		
		System.out.println("Job status before execute:"+jobExecution.getStatus());
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("JobMonituringListener.afterJob()");
		System.out.println("Job Ended at::"+new Date());
		end=System.currentTimeMillis();
		
		System.out.println("Job status->after execution:"+jobExecution.getStatus());
		System.out.println("Time taken to complete the Job"+(end-start)+"ms");
	}
}
