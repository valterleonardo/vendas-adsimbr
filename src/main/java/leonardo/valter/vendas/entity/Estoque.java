package leonardo.valter.vendas.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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

import lombok.Data;

@Entity
@Data
@Table(name = "ESTOQUE")
@SequenceGenerator(name = "seq_estoque", sequenceName = "seq_estoque_id", allocationSize = 1)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Estoque implements Serializable{
	
	private static final long serialVersionUID = 938260124131862175L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_estoque")
	private Integer id;
	private Integer quantidade;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao = new Date();
	
	@Column(columnDefinition="BOOLEAN NOT NULL DEFAULT true")
	private boolean ativo = true;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;
	
}
