package com.epicgames.egbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class EgBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EgBackendApplication.class, args);
	}

}
