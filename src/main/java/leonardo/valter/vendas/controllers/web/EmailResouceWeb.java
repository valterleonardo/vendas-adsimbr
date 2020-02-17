package leonardo.valter.vendas.controllers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import leonardo.valter.vendas.controllers.infra.EmailService;

@Controller
public class EmailResouceWeb {
	
	@Autowired EmailService emailService;
	
	@GetMapping(value = "/comunicarFornecedores")
	public String comunicarFornecedores() {
		
		emailService.enviarPedidosParaFornecedores();
		return "redirect:/pedidos";
	}
}
