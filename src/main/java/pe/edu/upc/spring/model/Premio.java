package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Premio")
public class Premio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPremio;
	
	@Column(name="nombrePremio", length=60, nullable=false)
	private String namePremio;

	public Premio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Premio(int idPremio, String namePremio) {
		super();
		this.idPremio = idPremio;
		this.namePremio = namePremio;
	}

	public int getIdPremio() {
		return idPremio;
	}

	public void setIdPremio(int idPremio) {
		this.idPremio = idPremio;
	}

	public String getNamePremio() {
		return namePremio;
	}

	public void setNamePremio(String namePremio) {
		this.namePremio = namePremio;
	}
	
}
