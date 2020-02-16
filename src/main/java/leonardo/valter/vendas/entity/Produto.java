package leonardo.valter.vendas.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name = "PRODUTO")
public class Produto implements Serializable{
	 
	private static final long serialVersionUID = 3212820522451290777L;
	
	@Id @GeneratedValue
	private Integer id;
	private String descricao;
	
	@Column(columnDefinition="BOOLEAN NOT NULL DEFAULT true")
	private boolean ativo;
	
	@Column(columnDefinition="TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao = new Date();

}