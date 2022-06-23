package com.ricardo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class FirstSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringbootApplication.class, args);
	}

}
