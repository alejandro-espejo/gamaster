package br.edu.gama.gamaster.testService;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import br.edu.gama.gamaster.model.Cliente;
import br.edu.gama.gamaster.repository.ClienteRepository;
import br.edu.gama.gamaster.service.ClienteService;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteServiceTest {
	
	@Autowired
	private ClienteRepository clienteRepository;
	

	@Test
	public void buscarPorID() {
		Cliente cliente = clienteRepository.findById(1L).orElse(null);
		Assert.assertNotNull(cliente);
	}
}
