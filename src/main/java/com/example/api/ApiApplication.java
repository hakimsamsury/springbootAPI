package com.example.api;

import com.example.api.domain.User;
import com.example.api.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository repository) {
		return args -> {
			User akmal = new User("akmal", "12345", 1);
			User alex = new User("alex", "12345", 2);

			repository.save(akmal);
			repository.save(alex);
		};

	}
}


