package leonardo.valter.vendas.controllers.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import leonardo.valter.vendas.entity.Cliente;
import leonardo.valter.vendas.entity.Pedido;
import leonardo.valter.vendas.entity.Produto;
import leonardo.valter.vendas.entity.repository.cliente.ClienteRepository;
import leonardo.valter.vendas.entity.repository.pedido.PedidoRepository;
import leonardo.valter.vendas.entity.repository.produto.ProdutoRepository;

@Controller
public class PedidoResourceWeb {
	
	@Autowired private PedidoRepository pedidoRepository;
	@Autowired private ClienteRepository clienteRepository;
	@Autowired private ProdutoRepository produtoRepository;

	@GetMapping(value = "/cadastrarPedido")
	public ModelAndView form(){
		ModelAndView mv = new ModelAndView("pedido/formPedido");
		Iterable<Cliente> clientes = clienteRepository.findAll();
		mv.addObject("clientes", clientes);
		Iterable<Produto> produtos = produtoRepository.findAll();
		mv.addObject("produtos", produtos);
		
		return mv;
	}
	
	@PostMapping(value = "/cadastrarPedido")
	public String form(Pedido pedido) {
		
		pedidoRepository.save(pedido);
		return "redirect:/pedidos";
	}
	
	@GetMapping(value = "/pedidos")
	public ModelAndView listaPedidos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Pedido> pedidos = pedidoRepository.findAll();
		mv.addObject("pedidos", pedidos);
		
		return mv;
	}
}
