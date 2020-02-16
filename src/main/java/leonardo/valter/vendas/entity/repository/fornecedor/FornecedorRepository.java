package leonardo.valter.vendas.entity.repository.fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;

import leonardo.valter.vendas.entity.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>, FornecedorInterface {

}
