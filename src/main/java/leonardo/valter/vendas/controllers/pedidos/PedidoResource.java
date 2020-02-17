package leonardo.valter.vendas.controllers.pedidos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leonardo.valter.vendas.entity.Pedido;
import leonardo.valter.vendas.entity.dict.StatusPedido;
import leonardo.valter.vendas.entity.repository.pedido.PedidoRepository;

@RestController
@RequestMapping(value="/api/pedido")
@CrossOrigin
public class PedidoResource {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> buscarPedidos(){
		
		List<Pedido> listaPedidos = pedidoRepository.findByStatus(StatusPedido.NOVO);
		return new ResponseEntity<List<Pedido>>(listaPedidos, HttpStatus.ACCEPTED);
	}
	
	@PutMapping
	public ResponseEntity<Pedido> adicionarPedido(@RequestBody Pedido pedido){
		
		Pedido novoPedido = pedidoRepository.save(pedido);
		return new ResponseEntity<Pedido>(novoPedido, HttpStatus.ACCEPTED);
	}
}