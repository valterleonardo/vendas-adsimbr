package leonardo.valter.vendas.entity.repository.pedido;

import org.springframework.data.jpa.repository.JpaRepository;

import leonardo.valter.vendas.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>, PedidoInterface {

}
