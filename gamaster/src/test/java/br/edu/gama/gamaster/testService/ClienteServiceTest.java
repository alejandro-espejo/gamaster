package br.edu.gama.gamaster.testService;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.edu.gama.gamaster.model.Cliente;
import br.edu.gama.gamaster.service.ClienteService;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
//@Sql(scripts = "")
public class ClienteServiceTest {
	
	@Autowired
	private ClienteService clienteService;	

	@Test
	public void buscarPorID() {
		Cliente cliente = clienteService.buscarPorCodigo(5L);
		Assert.assertNotNull(cliente);
	}
}

