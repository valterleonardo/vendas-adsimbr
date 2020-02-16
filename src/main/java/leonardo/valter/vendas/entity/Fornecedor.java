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
@Table(name = "FORNECEDOR")
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1893857868091200781L;

	@Id @GeneratedValue
	private Integer id;
	private String nome;
	
	@Column(columnDefinition="BOOLEAN NOT NULL DEFAULT true")
	private boolean ativo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
}
