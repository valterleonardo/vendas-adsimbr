package leonardo.valter.vendas.entity.repository.estoque;

import org.springframework.data.jpa.repository.JpaRepository;

import leonardo.valter.vendas.entity.Produto;

public interface EstoqueRepository  extends JpaRepository<Produto, Integer>, EstoqueService {
	
}