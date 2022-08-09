package com.example.practice_razorpay_one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.example.practice_razorpay_one")
@EnableScheduling
public class PracticeRazorpayOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeRazorpayOneApplication.class, args);
	}

}
