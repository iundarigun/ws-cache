package br.com.devcave.ws.client.services;

import br.com.devcave.ws.client.dto.PersonVO;
import feign.Param;
import feign.RequestLine;

public interface PersonService {

    @RequestLine("GET /person/id/{id}")
    PersonVO getById(@Param("id") Long id);

    @RequestLine("GET /person/email/{email}/")
    PersonVO getByEmail(@Param("email") String email);
}
