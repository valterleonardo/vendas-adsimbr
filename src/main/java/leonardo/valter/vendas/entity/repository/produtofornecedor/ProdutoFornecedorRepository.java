package leonardo.valter.vendas.entity.repository.produtofornecedor;

import org.springframework.data.jpa.repository.JpaRepository;

import leonardo.valter.vendas.entity.Produto;

public interface ProdutoFornecedorRepository extends JpaRepository<Produto, Integer>, ProdutoFornedorService {

}
