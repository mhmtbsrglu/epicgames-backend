package com.epicgames.egbackend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
@EnableAspectJAutoProxy(proxyTargetClass = true)
@OpenAPIDefinition(info = @Info(title = "EpicGames API", version = "1.0", description = "Store Information"))
public class EgBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EgBackendApplication.class, args);
	}

}
