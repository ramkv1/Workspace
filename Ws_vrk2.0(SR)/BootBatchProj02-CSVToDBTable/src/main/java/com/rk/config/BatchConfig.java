package com.rk.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.rk.listener.JobMonitoringListener;
import com.rk.model.Employee;
import com.rk.processor.EmployeeInfoItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jobFactory;
	@Autowired
	private StepBuilderFactory stepFactory;
	@Autowired
	private JobMonitoringListener listener;
	@Autowired
	private EmployeeInfoItemProcessor processor;
	@Autowired
	private DataSource ds;
	
	
	/*	  @Bean(name="ffiReader") public FlatFileItemReader<Employee>
		  createFFIReader(){ //create Reader object FlatFileItemReader<Employee>
		  reader=new FlatFileItemReader<Employee>(); //set csv file as resource
		  reader.setResource(new ClassPathResource("EmployeeInfo.csv")); //create
		  LineTokenizer (to get tokenizer from lines) DefaultLineMapper<Employee>
		  lineMapper=new DefaultLineMapper<Employee>(); //create LimeTokenizer (to get
		  tokens from lines) DelimitedLineTokenizer tokenizer=new
		  DelimitedLineTokenizer(); tokenizer.setDelimiter(",");
		  tokenizer.setNames("empno","ename","eadd","salary"); //create Fieldsetmapper
		  (To set the token to Model class object properties)
		  BeanWrapperFieldSetMapper<Employee> fieldSetMapper=new
		  BeanWrapperFieldSetMapper<Employee>();
		  fieldSetMapper.setTargetType(Employee.class);
		  
		  //set tokenizer, fieldSetMapper Object to LineMapper
		  lineMapper.setFieldSetMapper(fieldSetMapper);
		  lineMapper.setLineTokenizer(tokenizer);
		  
		  
		  return reader; }
		  
		  @Bean(name="jbiw") public JdbcBatchItemWriter<Employee> createJBIWriter(){
		  //create JdbcBatchitemWriter JdbcBatchItemWriter<Employee> writer=new
		  JdbcBatchItemWriter<Employee>(); //set DatabaseSource
		  writer.setDataSource(ds); //Ser INSERT SQL Query with named params writer.
		  setSql("INSERT INTO BATCH_EMPLOYEEINFO VALUES(:empno,:ename,:eadd,:salary,:grossSalary,:netSalary)"
		  ); //create BeanpropertyItemSqlParameterSourceprovider Object
		  BeanPropertyItemSqlParameterSourceProvider<Employee> sourceProvider=new
		  BeanPropertyItemSqlParameterSourceProvider<Employee>(); //set SourceProver to
		  writer object writer.setItemSqlParameterSourceProvider(sourceProvider);
		  
		  return writer;
		  }*/
	/////////////==================**************========================================
	
	///////////////=====================================================================
	 
	/*	
			//by Using reasdyMade Bilder clss
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Bean(name="ffiReader")
			public FlatFileItemReader<Employee> createFFIReader(){
				return new FlatFileItemReaderBuilder()
						.name("file-reader")
						.resource(new ClassPathResource("EmployeeInfo.csv"))
						.delimited()
						.names("empno","ename","eadd","salary")
						.targetType(Employee.class)
						.build();
			}
			//Using Builder class
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Bean(name="jbiw")
			public JdbcBatchItemWriter<Employee> createJBIWriter(){
				return new JdbcBatchItemWriterBuilder()
						.dataSource(ds)
						.sql("INSERT INTO BATCH_EMPLOYEEINFO VALUES(:empno,:ename,:eadd,:salary,:grossSalary,:netSalary)")
						.beanMapped()
						.build();
			}
			
			*/
		
	///////=================================*********==================================================
	
	////===================Using Anonymous sub class and instance block=======================
	
	
		@Bean(name="ffiReader")
		public FlatFileItemReader<Employee> createFFIReader(){
			//create Reader object
			FlatFileItemReader<Employee> reader=new FlatFileItemReader<Employee>();
			//set csv file as resource
			reader.setResource(new ClassPathResource("EmployeeInfo.csv"));
			//set LineMapper Object
			reader.setLineMapper(new DefaultLineMapper<Employee>() {{
				
				//set DelimetedTokenizer object
				setLineTokenizer(new DelimitedLineTokenizer() {{
						
				setDelimiter(",");
				setNames("empno","ename","eadd","salary");
				}});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {{
					setTargetType(Employee.class);	
				}});
			}});
		return reader;
		}
		
		//Using Anonymous sub class and instance block
		@Bean(name="jbiw")
		public JdbcBatchItemWriter<Employee> createJBIWriter(){
			//Create jdbcBatchItemWritter
			JdbcBatchItemWriter<Employee> writer=new JdbcBatchItemWriter<Employee>() {{
			//set Data source
			setDataSource(ds);
			setSql("INSERT INTO BATCH_EMPLOYEEINFO VALUES(:empno,:ename,:eadd,:salary,:grossSalary,:netSalary)");
			setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
	
			}};
			return writer;
		}
	
	//////=====================================******========================================
	@Bean(name="step1")
	public Step createStep1() {
		return stepFactory.get("step1")
				.<Employee,Employee>chunk(5)
				.reader(createFFIReader())
				.processor(processor)
				.writer(createJBIWriter())
				.build();
	}
	@Bean(name="job1")
	public Job createJob1() {
		return jobFactory.get("job1")
				.listener(listener)
				.incrementer(new RunIdIncrementer())
				.start(createStep1())
				.build();
	}
	
}
