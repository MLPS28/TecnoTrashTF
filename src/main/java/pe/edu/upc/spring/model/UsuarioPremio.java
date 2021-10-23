package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Usuario")
public class UsuarioPremio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="CUsuarioPremio", nullable = false)
	private int CUsuarioPremio; 

	@ManyToOne
	@JoinColumn(name = "CPremio")
	private Premio Objpremio;
	

	@ManyToOne
	@JoinColumn(name = "CUsuario")
	private Usuario Objusuario;

	@Column(name = "QReportes", nullable = false)
	private int QReportes;
	
	@Column(name = "DFecha", nullable = false)
	private Date DFecha;
	
	@Column(name = "DHora", nullable = false, length = 20)
	private String DHora;

	public UsuarioPremio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioPremio(int cUsuarioPremio, pe.edu.upc.spring.model.Premio objpremio,
			pe.edu.upc.spring.model.Usuario objusuario, int qReportes, Date dFecha, String dHora) {
		super();
		CUsuarioPremio = cUsuarioPremio;
		Objpremio = objpremio;
		Objusuario = objusuario;
		QReportes = qReportes;
		DFecha = dFecha;
		DHora = dHora;
	}

	public int getCUsuarioPremio() {
		return CUsuarioPremio;
	}

	public void setCUsuarioPremio(int cUsuarioPremio) {
		CUsuarioPremio = cUsuarioPremio;
	}

	public Premio getObjpremio() {
		return Objpremio;
	}

	public void setObjpremio(Premio objpremio) {
		Objpremio = objpremio;
	}

	public Usuario getObjusuario() {
		return Objusuario;
	}

	public void setObjusuario(Usuario objusuario) {
		Objusuario = objusuario;
	}

	public int getQReportes() {
		return QReportes;
	}

	public void setQReportes(int qReportes) {
		QReportes = qReportes;
	}

	public Date getDFecha() {
		return DFecha;
	}

	public void setDFecha(Date dFecha) {
		DFecha = dFecha;
	}

	public String getDHora() {
		return DHora;
	}

	public void setDHora(String dHora) {
		DHora = dHora;
	}
	
	
	
}
