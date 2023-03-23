package com.rk.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocConfiguration {
	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.rk.rest"))
			.paths(PathSelectors.regex("/doctor.*"))
			.build()
			.useDefaultResponseMessages(true)
			.apiInfo(getAPIInfo());
	
}
	
	private ApiInfo getAPIInfo() {
		Contact contact=new Contact("java","http://www.nareshit.com","java@gmail.com");
		return new ApiInfo("Doctor API", "info about doctors", "1.0 RELEASE", "http://www.nareshit.com",contact, "Opensource lincense", "http://www.nareshit.com/license",Collections.emptyList());
	
	}
}
