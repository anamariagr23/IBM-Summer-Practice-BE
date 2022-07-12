package com.ibm.ro.tm.apprenticeship.poll.metter.be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ibm.ro.tm.apprenticeship.poll.metter.controller.UserController;

@SpringBootApplication
@ComponentScan(basePackageClasses = { UserController.class, //
		DataLoader.class, //
		SwaggerConfiguration.class })
@EntityScan(basePackages = { "com.ibm.ro.tm.apprenticeship.poll.metter.entity" })
@EnableJpaRepositories(basePackages = { "com.ibm.ro.tm.apprenticeship.poll.metter.repository" })
public class PollMetterBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollMetterBeApplication.class, args);
	}
}
