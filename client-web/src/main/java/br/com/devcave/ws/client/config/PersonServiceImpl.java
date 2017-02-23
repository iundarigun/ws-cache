package br.com.devcave.ws.client.config;

import br.com.devcave.ws.client.dto.PersonVO;
import br.com.devcave.ws.client.services.PersonService;
import feign.Param;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("local")
@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public PersonVO getById(@Param("id") Long id) {
        if (id <= 3) {
            return new PersonVO(id,//
                    "test" + id + "@devcave.com.br",//
                    "Teste " + id + " devcave");
        }
        return null;
    }

    @Override
    public PersonVO getByEmail(@Param("email") String email) {
        if (email.contains("devcave")) {
            return new PersonVO(1L, email, "Teste devcave");
        }
        return null;
    }
}
