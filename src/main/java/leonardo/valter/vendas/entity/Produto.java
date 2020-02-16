package leonardo.valter.vendas.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name = "PRODUTO")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto_id", allocationSize = 1)
public class Produto implements Serializable{
	 
	private static final long serialVersionUID = 3212820522451290777L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_produto")
	private Integer id;
	private String descricao;
	
	@Column(columnDefinition="BOOLEAN NOT NULL DEFAULT true")
	private boolean ativo;
	
	@Column(columnDefinition="TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao = new Date();

}