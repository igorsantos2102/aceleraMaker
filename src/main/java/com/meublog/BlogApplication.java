package com.meublog;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.meublog.service.PostagemService; 


@SpringBootApplication(scanBasePackages = {"com.meublog"})
public class BlogApplication {

	  public static void main(String[] args) {
	        SpringApplication.run(BlogApplication.class, args);
	    }
}