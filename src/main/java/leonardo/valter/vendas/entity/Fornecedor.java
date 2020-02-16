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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
@Table(name = "FORNECEDOR")
@SequenceGenerator(name = "seq_fornecedor", sequenceName = "seq_fornecedor_id", allocationSize = 1)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1893857868091200781L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_fornecedor")
	private Integer id;
	private String nome;
	private String email;
	
	@Column(columnDefinition="BOOLEAN NOT NULL DEFAULT true")
	private boolean ativo = true;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao = new Date();
}
