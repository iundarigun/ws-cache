package br.com.devcave.ws.client.controllers;

import br.com.devcave.ws.client.dto.PersonForm;
import br.com.devcave.ws.client.dto.PersonVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {

    @RequestMapping(value = "/person/search", method = RequestMethod.GET)
    public ModelAndView getPerson(PersonForm form){
        ModelAndView modelAndView = new ModelAndView("person");
        if (form.getId()!=null){
            RestTemplate restTemplate = new RestTemplate();
            PersonVO personVO = restTemplate.getForObject("http://localhost:1980/person/id/" + form.getId(), PersonVO.class);
            modelAndView.addObject("person", personVO);
        }
        else if (StringUtils.isNotBlank(form.getEmail())){
            RestTemplate restTemplate = new RestTemplate();
            PersonVO personVO = restTemplate.getForObject("http://localhost:1980/person/email/" + form.getId(), PersonVO.class);
            modelAndView.addObject("person", personVO);
        }
        else{
            return new ModelAndView("index");
        }
        return modelAndView;
    }

}
