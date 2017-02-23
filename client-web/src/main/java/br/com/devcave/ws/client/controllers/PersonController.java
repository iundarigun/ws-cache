package br.com.devcave.ws.client.controllers;

import br.com.devcave.ws.client.dto.PersonForm;
import br.com.devcave.ws.client.dto.PersonVO;
import br.com.devcave.ws.client.services.PersonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/person/search", method = RequestMethod.GET)
    public ModelAndView getPerson(PersonForm form){
        ModelAndView modelAndView = new ModelAndView("person");
        if (form.getId()!=null){
            PersonVO personVO = personService.getById(form.getId());
            modelAndView.addObject("person", personVO);
        }
        else if (StringUtils.isNotBlank(form.getEmail())){
            PersonVO personVO = personService.getByEmail(form.getEmail());
            modelAndView.addObject("person", personVO);
        }
        else{
            return new ModelAndView("index");
        }
        return modelAndView;
    }

}
