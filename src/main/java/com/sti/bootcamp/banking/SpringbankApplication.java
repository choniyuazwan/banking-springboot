package com.sti.bootcamp.banking;

import com.sti.bootcamp.banking.config.BeanConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import(BeanConfig.class)
@EntityScan({"com.sti.bootcamp.banking.db.model"})
@EnableJpaRepositories({"com.sti.bootcamp.banking.db.repository"})
public class SpringbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbankApplication.class, args);
	}

}
