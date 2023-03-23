package com.rk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "com.rk")
@ImportResource("com/rk/cfgs/applicationContext.xml")
public class AppConfig {

}
