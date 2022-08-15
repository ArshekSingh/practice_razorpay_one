package com.example.practice_razorpay_one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.example.practice_razorpay_one")
@EnableScheduling
@EnableJpaRepositories("com.example.practice_razorpay_one")
public class PracticeRazorpayOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeRazorpayOneApplication.class, args);
	}

}
