package com.rk.runner;

import java.util.Random;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class BatchTestRunner implements CommandLineRunner {
	@Autowired
	private JobLauncher launcher;
	@Autowired
	private Job job;
	
	@Override
	public void run(String... args) throws Exception {
		//create JobParameters
		JobParameters params=new JobParametersBuilder().addLong("run.id",new Random().nextLong(1000)).toJobParameters();
		//run the Job
		/*		JobExecution execution=launcher.run(job, params);
				System.out.println("Job Ececution status::"+execution.getExitStatus());
				
				*/
		
	}

}
