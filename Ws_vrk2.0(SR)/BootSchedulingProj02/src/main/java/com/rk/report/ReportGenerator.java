package com.rk.report;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("report")
public class ReportGenerator {
//	@Scheduled(cron = "0 0 * * * 6-7")	//==>Every Hour On Weekend
//	@Scheduled(cron = "0 0 10 * * 7")	//==>Every Sunday 10am
//	@Scheduled(cron = "* * * * * *")	//==>Every time
//	@Scheduled(cron = "* 13 15 * * *")	
//	@Scheduled(initialDelay = 200,fixedDelay = 2000)
	@Scheduled(cron = "*/5 * * * * *")
	public void generateSalesReport() {
		System.out.println("------------SalesReport on--------::"+new Date());
	}
}