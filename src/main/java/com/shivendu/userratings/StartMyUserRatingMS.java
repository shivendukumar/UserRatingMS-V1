package com.shivendu.userratings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
public class StartMyUserRatingMS implements CommandLineRunner{

	static Logger log = LoggerFactory.getLogger(StartMyUserRatingMS.class);
	
	public static void main(String[] args) {
		SpringApplication.run(StartMyUserRatingMS.class, args);

	}
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
