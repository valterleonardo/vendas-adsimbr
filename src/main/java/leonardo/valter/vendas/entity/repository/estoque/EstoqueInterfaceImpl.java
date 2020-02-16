package leonardo.valter.vendas.entity.repository.estoque;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class EstoqueServiceImpl implements EstoqueService {
	
	@PersistenceContext
    private EntityManager entityManager;
}
