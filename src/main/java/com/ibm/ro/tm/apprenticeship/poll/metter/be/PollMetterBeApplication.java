package com.ibm.ro.tm.apprenticeship.poll.metter.be;

import java.util.Arrays;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.ibm.ro.tm.apprenticeship.poll.metter.controller.AnswerController;
import com.ibm.ro.tm.apprenticeship.poll.metter.controller.PollController;
import com.ibm.ro.tm.apprenticeship.poll.metter.controller.UserController;

@SpringBootApplication
@ComponentScan(basePackageClasses = { UserController.class, AnswerController.class ,
		PollController.class, SwaggerConfiguration.class })
@EntityScan(basePackages = { "com.ibm.ro.tm.apprenticeship.poll.metter.entity" })
@EnableJpaRepositories(basePackages = { "com.ibm.ro.tm.apprenticeship.poll.metter.repository" })
@EnableAutoConfiguration
public class PollMetterBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollMetterBeApplication.class, args);
	}
	
	@Bean(name="c1")
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3306"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Acces-Control-Allow-Origin", "Content-Type", "Accept",
				"Authorization", "Origin, Accept", "X-Request-With", "Acces-Control-Request-Method", "Acces-Control-Request-Headers"));
		
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Acces-Control-Allow-Origin",
				"Authorization", "Acces-Control-Allow-Credentials"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter();
	}
}
