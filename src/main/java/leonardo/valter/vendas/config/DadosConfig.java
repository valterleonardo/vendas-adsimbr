package leonardo.valter.vendas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import leonardo.valter.vendas.entity.Cliente;
import leonardo.valter.vendas.entity.Fornecedor;
import leonardo.valter.vendas.entity.Pedido;
import leonardo.valter.vendas.entity.Produto;
import leonardo.valter.vendas.entity.dict.StatusPedido;
import leonardo.valter.vendas.entity.repository.cliente.ClienteRepository;
import leonardo.valter.vendas.entity.repository.fornecedor.FornecedorRepository;
import leonardo.valter.vendas.entity.repository.pedido.PedidoRepository;
import leonardo.valter.vendas.entity.repository.produto.ProdutoRepository;

@Configuration
public class DadosConfig {
	
	@Autowired ProdutoRepository 	produtoRepository;
	@Autowired FornecedorRepository fornecedorRepository;
	@Autowired ClienteRepository 	clienteRepository;
	@Autowired PedidoRepository 	pedidoRepository;
	
	@Bean
    public void iniciarBancoDeDados() {
		for (int i = 1; i <= 5; i++) {
			
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setNome("Fornecedor "+i);
			fornecedor.setEmail("jonsnow@adsim.com.br");
			fornecedorRepository.save(fornecedor);
			
			Produto produto = new Produto();
			produto.setDescricao("As Crônicas de Gelo e Fogo "+i);
			produto.setFornecedor(fornecedor);
			produtoRepository.save(produto);
			
			Cliente cliente = new Cliente();
			cliente.setNome("Cliente "+i);
			clienteRepository.save(cliente);
			
			Pedido pedido = new Pedido();
			pedido.setCliente(cliente);
			pedido.setProduto(produto);
			pedido.setQuantidade(i);
			pedido.setStatus(StatusPedido.FINALIZADO);
			pedidoRepository.save(pedido);
	
		}
    }
}