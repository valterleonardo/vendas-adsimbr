package leonardo.valter.vendas.entity.repository.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import leonardo.valter.vendas.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>, ClienteService {

}
