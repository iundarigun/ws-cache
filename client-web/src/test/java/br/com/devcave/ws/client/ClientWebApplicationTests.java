package br.com.devcave.ws.client;

import br.com.devcave.ws.client.controllers.PersonController;
import br.com.devcave.ws.client.dto.PersonForm;
import br.com.devcave.ws.client.dto.PersonVO;
import br.com.devcave.ws.client.services.PersonService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ClientWebApplication.class})
public class ClientWebApplicationTests {

    @Autowired
	@InjectMocks
    private PersonController personController;
	@Mock
	private PersonService personService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSemPesquisa() {
        ModelAndView modelAndView = personController.getPerson(new PersonForm());
        Assert.assertEquals("redirect:/", modelAndView.getViewName());
    }

    @Test
    public void testPesquisandoPorIdExistente() {
        PersonVO personVO = new PersonVO(2L, "test2@devcave.com.br", "2o Teste da devCave");
		Mockito.when(personService.getById(2L)).thenReturn(personVO);
        ModelAndView modelAndView = personController.getPerson(new PersonForm(2L, null, null));
        Assert.assertEquals("person", modelAndView.getViewName());
        PersonVO result = (PersonVO) modelAndView.getModel().get("person");
        Assert.assertEquals(personVO, result);
    }

    @Test
    public void testPesquisandoPorIdInexistente() {
		Mockito.when(personService.getById(5L)).thenReturn(null);
        ModelAndView modelAndView = personController.getPerson(new PersonForm(5L, null, null));
        Assert.assertEquals("person", modelAndView.getViewName());
        PersonVO result = (PersonVO) modelAndView.getModel().get("person");
        Assert.assertNull(result);
    }
}
