package com.bediss.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BedissHotelbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BedissHotelbackendApplication.class, args);
	}
	
    @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// registry.addMapping("/**").allowedOrigins("http://localhost:4200"); autorise l'accès depuis localhost:4200 
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
				// * dans allow origins : çad autoriser toutes les machines 
			}
		};
	}
    

    
    


}
