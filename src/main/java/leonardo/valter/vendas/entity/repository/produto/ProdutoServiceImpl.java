package leonardo.valter.vendas.entity.repository.produto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import leonardo.valter.vendas.entity.Produto;

@Repository
public class ProdutoServiceImpl implements ProdutoService {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public Produto findaProduto() {
		try {    		
    		String sql = "select * from produto where id = ?1";
    		Query query = entityManager.createNativeQuery(sql, Produto.class);
    		Produto produto = (Produto) query.setParameter(1, 5)
    										 .getSingleResult();

            return produto;
			
		} catch (Exception e) {
			return null;
			
		} finally {
			entityManager.close();
		} 
	}
}