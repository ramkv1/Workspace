package com.rk.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.rk.model.Employee;

@Component("processor")
public class EmployeeInfoItemProcessor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee item) throws Exception {
		
		if(item.getSalary()>=100000) {
			//calculate gross and net salaries
			item.setGrossSalary(item.getSalary()+(item.getSalary()*0.4f));
			item.setNetSalary(item.getGrossSalary()-(item.getGrossSalary()*0.2f));
			return item;
		}
		return null;
	}

}
