package leonardo.valter.vendas.entity.repository.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import leonardo.valter.vendas.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>, ProdutoService {
	
	public Produto findaProduto();
}
