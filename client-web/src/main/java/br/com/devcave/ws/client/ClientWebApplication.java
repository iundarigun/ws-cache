package br.com.devcave.ws.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ClientWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientWebApplication.class, args);
	}
}
