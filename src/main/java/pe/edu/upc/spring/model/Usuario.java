package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name="nombreUsuario", length=60, nullable=false)
	private String nameUsuario;

	@Column(name="NDNI", nullable = false)
	private int NDNI;
	
	@Column(name="NEmail", length=60, nullable=false)
	private String NEmail;
	
	@Column(name="NPassword", length = 30, nullable = false)
	private String NPassword;
	
	@Column(name="QPuntos", length = 10, nullable = false)
	private int QPuntos;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int idUsuario, String nameUsuario, int nDNI, String nEmail, String nPassword, int qPuntos) {
		super();
		this.idUsuario = idUsuario;
		this.nameUsuario = nameUsuario;
		NDNI = nDNI;
		NEmail = nEmail;
		NPassword = nPassword;
		QPuntos = qPuntos;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNameUsuario() {
		return nameUsuario;
	}

	public void setNameUsuario(String nameUsuario) {
		this.nameUsuario = nameUsuario;
	}

	public int getNDNI() {
		return NDNI;
	}

	public void setNDNI(int nDNI) {
		NDNI = nDNI;
	}

	public String getNEmail() {
		return NEmail;
	}

	public void setNEmail(String nEmail) {
		NEmail = nEmail;
	}

	public String getNPassword() {
		return NPassword;
	}

	public void setNPassword(String nPassword) {
		NPassword = nPassword;
	}

	public int getQPuntos() {
		return QPuntos;
	}

	public void setQPuntos(int qPuntos) {
		QPuntos = qPuntos;
	}

	
}
