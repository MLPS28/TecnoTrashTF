package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoVia")
public class TipoVia implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoVia;
	
	@Column(name="nombreTipoVia", length=60, nullable=false)
	private String nameTipoVia;

	public TipoVia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoVia(int idTipoVia, String nameTipoVia) {
		super();
		this.idTipoVia = idTipoVia;
		this.nameTipoVia = nameTipoVia;
	}

	public int getIdTipoVia() {
		return idTipoVia;
	}

	public void setIdTipoVia(int idTipoVia) {
		this.idTipoVia = idTipoVia;
	}

	public String getNameTipoVia() {
		return nameTipoVia;
	}

	public void setNameTipoVia(String nameTipoVia) {
		this.nameTipoVia = nameTipoVia;
	}

}
