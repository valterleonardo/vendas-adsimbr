package leonardo.valter.vendas.controllers.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leonardo.valter.vendas.entity.Cliente;
import leonardo.valter.vendas.entity.Estoque;
import leonardo.valter.vendas.entity.Fornecedor;
import leonardo.valter.vendas.entity.Pedido;
import leonardo.valter.vendas.entity.Produto;
import leonardo.valter.vendas.entity.repository.cliente.ClienteRepository;
import leonardo.valter.vendas.entity.repository.estoque.EstoqueRepository;
import leonardo.valter.vendas.entity.repository.fornecedor.FornecedorRepository;
import leonardo.valter.vendas.entity.repository.pedido.PedidoRepository;
import leonardo.valter.vendas.entity.repository.produto.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="/api/infra")
@CrossOrigin
@Slf4j
public class InfraResource {
	
	@Autowired ProdutoRepository 	produtoRepository;
	@Autowired FornecedorRepository fornecedorRepository;
	@Autowired EstoqueRepository 	estoqueRepository;
	@Autowired ClienteRepository 	clienteRepository;
	@Autowired PedidoRepository 	pedidoRepository;
	
	@GetMapping("/ping")
	public ResponseEntity<String> ping() {	
		log.info("RequestService: /ping");		
	    return new ResponseEntity<>("Pong!", HttpStatus.OK);
	}
	
	@GetMapping("/iniciar-banco")
	public ResponseEntity<String> iniciarBancoDeDados() {	

		for (int i = 1; i <= 5; i++) {
			
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setNome("Fornecedor "+i);
			fornecedor.setEmail("vlmb.leo@gmail.com");
			fornecedorRepository.save(fornecedor);
			
			Produto produto = new Produto();
			produto.setDescricao("Livro "+i);
			produto.setFornecedor(fornecedor);
			produtoRepository.save(produto);
			
			Estoque estoque = new Estoque();
			estoque.setProduto(produto);
			estoque.setQuantidade(i);
			estoqueRepository.save(estoque);
			
			Cliente cliente = new Cliente();
			cliente.setNome("Cliente "+i);
			clienteRepository.save(cliente);
			
			Pedido pedido = new Pedido();
			pedido.setCliente(cliente);
			pedido.setProduto(produto);
			pedido.setQuantidade(i);
			pedidoRepository.save(pedido);
	
		}
		
	    return new ResponseEntity<>("Banco Iniciado", HttpStatus.OK);
	}
}