/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.be;

import java.util.Arrays;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * @author O09860826
 *
 */
@Configuration
class DataLoader {

	@Bean(name="crsConfing")
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
