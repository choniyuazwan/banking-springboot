package com.sti.bootcamp.banking;

import com.sti.bootcamp.banking.config.BeanConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@Import(BeanConfig.class)
@EntityScan({"com.sti.bootcamp.banking.db.model"})
@EnableJpaRepositories({"com.sti.bootcamp.banking.db.repository"})
public class SpringbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbankApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("").allowedOrigins("http://localhost:8080");
//			}
//		};
//	}

}
