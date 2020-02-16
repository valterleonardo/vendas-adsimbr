package leonardo.valter.vendas.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name = "PEDIDO")
@SequenceGenerator(name = "seq_pedido", sequenceName = "seq_pedido_id", allocationSize = 1)
public class Pedido implements Serializable {

	private static final long serialVersionUID = 722480202727676139L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_pedido")
	private Integer id;
	private Integer quantidade;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Column(columnDefinition="BOOLEAN NOT NULL DEFAULT true")
	private boolean ativo;
	
	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;
	
	@OneToMany
	@JoinColumn(name = "produto_fornecedor_id", nullable = false)
	private List<ProdutoFornecedor> produtoFornecedor;
	
	@OneToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
}