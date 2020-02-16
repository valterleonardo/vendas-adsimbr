package leonardo.valter.vendas.entity.repository.estoque;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class EstoqueInterfaceImpl implements EstoqueInterface {
	
	@PersistenceContext
    private EntityManager entityManager;
}
