package br.com.devcave.ws.client.controllers;

import br.com.devcave.ws.client.dto.PersonForm;
import br.com.devcave.ws.client.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("personForm", new PersonForm());
        modelAndView.addObject("count", personService.countPerson());
        return modelAndView;
    }

}
