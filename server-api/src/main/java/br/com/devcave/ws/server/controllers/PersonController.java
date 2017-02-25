package br.com.devcave.ws.server.controllers;

import br.com.devcave.ws.server.domain.Person;
import br.com.devcave.ws.server.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/email/{email}/", method = RequestMethod.GET)
    public Person getPersonByEmail(@PathVariable("email") String email){
        log.info("M=getPersonByEmail, email={}",email);
        return personRepository.findFirstByEmail(email);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void updatePerson(@RequestBody Person person){
        log.info("M=updatePerson, person={}",person);
        personRepository.save(person);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Long countPerson(){
        log.info("M=countPerson");
        return new Long(personRepository.count());
    }
}
