package leonardo.valter.vendas.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexResourceWeb {
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/pedidos";
	}
}