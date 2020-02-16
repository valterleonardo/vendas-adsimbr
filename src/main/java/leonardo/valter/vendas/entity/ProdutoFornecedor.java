package leonardo.valter.vendas.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name = "PRODUTO_FORNECEDOR")
@SequenceGenerator(name = "seq_produto_fornecedor", sequenceName = "seq_produto_fornecedor_id", allocationSize = 1)
public class ProdutoFornecedor implements Serializable {
	
	private static final long serialVersionUID = -5229047234886542317L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_produto_fornecedor")
	private Integer id;
	
	@Column(columnDefinition="BOOLEAN NOT NULL DEFAULT true")
	private boolean ativo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "fornecedor_id", nullable = false)
	private Fornecedor fornecedor;
	
}
