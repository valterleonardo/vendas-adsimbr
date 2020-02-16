package leonardo.valter.vendas.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import leonardo.valter.vendas.entity.dict.StatusPedido;
import lombok.Data;

@Entity
@Data
@Table(name = "PEDIDO")
@SequenceGenerator(name = "seq_pedido", sequenceName = "seq_pedido_id", allocationSize = 1)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pedido implements Serializable {

	private static final long serialVersionUID = 722480202727676139L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_pedido")
	private Integer id;
	private Integer quantidade;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido status = StatusPedido.NOVO;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao = new Date();
	
	@Column(columnDefinition="BOOLEAN NOT NULL DEFAULT true")
	private boolean ativo = true;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
}