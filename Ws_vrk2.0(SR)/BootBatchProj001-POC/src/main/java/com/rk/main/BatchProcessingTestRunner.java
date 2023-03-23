package com.rk.main;

import java.util.Random;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component("BatchTestRunner")
public class BatchProcessingTestRunner implements CommandLineRunner {
	@Autowired
	private JobLauncher launcher;
	@Autowired
	private Job job;


	@Override
	public void run(String... args) throws Exception {
		//create JobParameters
				JobParameters parameters=new JobParametersBuilder().addLong("run.id", new Random().nextLong(1000)).toJobParameters();
				
					JobExecution execution=launcher.run(job,parameters);
					System.out.println("Job Execution exit status::"+execution.getExitStatus());
					System.out.println("Job start time::"+execution.getStartTime());
					System.out.println("Job endTime::"+execution.getEndTime());
				
					System.out.println("BatchProcessingTest.main()--(end)");
			
	}

}
