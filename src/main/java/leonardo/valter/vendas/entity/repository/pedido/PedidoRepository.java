package leonardo.valter.vendas.entity.repository.pedido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import leonardo.valter.vendas.entity.Pedido;
import leonardo.valter.vendas.entity.dict.StatusPedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>, PedidoInterface {

	public List<Pedido> findByStatus(StatusPedido novo);

}
