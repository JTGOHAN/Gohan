package com.GojanDev.solucionesGojanDev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class})
public class SolucionesGojanDevApplication {

	public static void main(String[] args) {

		SpringApplication.run(SolucionesGojanDevApplication.class, args);
	}

}
