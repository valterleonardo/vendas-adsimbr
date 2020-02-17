package leonardo.valter.vendas.entity.repository.pedido;

import java.util.List;

import leonardo.valter.vendas.entity.Pedido;
import leonardo.valter.vendas.entity.dict.StatusPedido;

public interface PedidoInterface {

	public List<Pedido> findByStatus(StatusPedido novo);
}
