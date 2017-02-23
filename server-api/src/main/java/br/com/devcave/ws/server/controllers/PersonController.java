package br.com.devcave.ws.server.controllers;

import br.com.devcave.ws.server.domain.Person;
import br.com.devcave.ws.server.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@Slf4j
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable("id") Long id){
        log.info("M=getPersonById, id={}",id);
        return personRepository.findOne(id);
    }

    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    public Person getPersonByEmail(@PathVariable("email") String email){
        return personRepository.findFirstByEmail(email);
    }
}
