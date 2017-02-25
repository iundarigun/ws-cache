package br.com.devcave.ws.client.services;

import br.com.devcave.ws.client.dto.PersonForm;
import br.com.devcave.ws.client.dto.PersonVO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public interface PersonService {

    @Cacheable("person")
    @RequestLine("GET /person/id/{id}")
    PersonVO getById(@Param("id") Long id);

    @Cacheable("person")
    @RequestLine("GET /person/email/{email}/")
    PersonVO getByEmail(@Param("email") String email);

    @CacheEvict(value = "person", key = "#root.args[0].id", beforeInvocation = true)
    @Headers("Content-Type: application/json")
    @RequestLine("POST /person/")
    void updatePerson(PersonForm personForm);

    @Cacheable(value="count", key="#root.methodName")
    @RequestLine("GET /person/count")
    Long countPerson();
}
