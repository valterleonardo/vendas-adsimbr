package leonardo.valter.vendas.entity.repository.estoque;

import org.springframework.data.jpa.repository.JpaRepository;

import leonardo.valter.vendas.entity.Estoque;

public interface EstoqueRepository  extends JpaRepository<Estoque, Integer>, EstoqueInterface {
	
}