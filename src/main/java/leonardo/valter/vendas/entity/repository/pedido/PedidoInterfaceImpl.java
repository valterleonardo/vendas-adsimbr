package leonardo.valter.vendas.entity.repository.pedido;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import leonardo.valter.vendas.entity.Pedido;
import leonardo.valter.vendas.entity.dict.StatusPedido;

@Repository
public class PedidoInterfaceImpl implements PedidoInterface {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Pedido> findByStatus(StatusPedido status) {
		try {    		
    		String sql = "select * from pedido where status = ?1";
    		Query query = entityManager.createNativeQuery(sql, Pedido.class);    		
			List<Pedido> pedidos = query.setParameter(1, status.name())
    										 .getResultList();
            return pedidos;
			
		} catch (NoResultException e) {
			return new ArrayList<Pedido>();
		} catch (Exception e) {
			throw e;		
		} finally {
			entityManager.close();
		} 
	}

}
