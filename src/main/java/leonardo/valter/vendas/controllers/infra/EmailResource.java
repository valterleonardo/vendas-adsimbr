package leonardo.valter.vendas.controllers.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/api/email")
@CrossOrigin
public class EmailResource {
	
	@Autowired EmailService emailService;
	
	@PostMapping(path = "/enviar-pedidos")
	public String enviarPedidosParaFornecedores() {
		return emailService.enviarPedidosParaFornecedores();
	}
}
