package br.com.devcave.ws.client.config;

import br.com.devcave.ws.client.services.PersonService;
import feign.Feign;
import feign.gson.GsonDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {
    @Bean
    public PersonService personService(){
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(PersonService.class, "http://localhost:1980");
    }
}
