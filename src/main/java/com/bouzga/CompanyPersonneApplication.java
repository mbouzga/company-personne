package com.bouzga;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.bouzga.dao.PersonneRepository;
import com.bouzga.entity.Personne;
@EnableDiscoveryClient
@SpringBootApplication
public class CompanyPersonneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyPersonneApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Bean
	CommandLineRunner start(PersonneRepository repository) {
		return args -> {
			Stream.of(new Personne(null, "BOUZGA", "Mountassir", 2000.50, "", false),
					new Personne(null, "DEGAULE", "Chales", 3000.20, "", true),
					new Personne(null, "DELANOY", "Claude", 1700.34, "", true),
					new Personne(null, "YOUSFI", "Mohamed", 5000.12, "", false))
					.forEach(personne -> repository.save(personne));
			repository.findAll().forEach(System.out::println);
		};
	}
}
