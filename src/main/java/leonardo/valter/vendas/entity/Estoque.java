package leonardo.valter.vendas.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name = "ESTOQUE")
public class Estoque implements Serializable{
	
	private static final long serialVersionUID = 938260124131862175L;
	
	@Id @GeneratedValue
	private Integer id;
	private Integer quantidade;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Column(columnDefinition="BOOLEAN NOT NULL DEFAULT true")
	private boolean ativo;
	
	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;
	
}
