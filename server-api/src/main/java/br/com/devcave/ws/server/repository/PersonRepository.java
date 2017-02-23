package br.com.devcave.ws.server.repository;

import br.com.devcave.ws.server.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findFirstByEmail(String email);
}
