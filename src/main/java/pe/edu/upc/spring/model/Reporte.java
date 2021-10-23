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
@Table(name="Reporte")
public class Reporte implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CReporte;
	
	@Column(name = "TDescripcion", nullable = false, length = 100)
	private String TDescripcion;
	
	@Column(name = "NUrlMultimedia", nullable = false, length = 400)
	private String NUrlMultimedia;
	
	@Column(name = "QPuntosxReporte", nullable = false)
	private int QPuntosxReporte;
	
	@Column(name = "DFecha", nullable = false)
	private Date DFecha;
	
	@Column(name = "DHora", nullable = false)
	private String DHora;
	
	@ManyToOne
	@JoinColumn(name = "CUsuario")
	private Usuario Objusuario;
	
	@ManyToOne
	@JoinColumn(name = "CDireccion")
	private Direccion Objdireccion;

	public Reporte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reporte(int cReporte, String tDescripcion, String nUrlMultimedia, int qPuntosxReporte, Date dFecha,
			String dHora, Usuario objusuario, Direccion objdireccion) {
		super();
		CReporte = cReporte;
		TDescripcion = tDescripcion;
		NUrlMultimedia = nUrlMultimedia;
		QPuntosxReporte = qPuntosxReporte;
		DFecha = dFecha;
		DHora = dHora;
		Objusuario = objusuario;
		Objdireccion = objdireccion;
	}

	public int getCReporte() {
		return CReporte;
	}

	public void setCReporte(int cReporte) {
		CReporte = cReporte;
	}

	public String getTDescripcion() {
		return TDescripcion;
	}

	public void setTDescripcion(String tDescripcion) {
		TDescripcion = tDescripcion;
	}

	public String getNUrlMultimedia() {
		return NUrlMultimedia;
	}

	public void setNUrlMultimedia(String nUrlMultimedia) {
		NUrlMultimedia = nUrlMultimedia;
	}

	public int getQPuntosxReporte() {
		return QPuntosxReporte;
	}

	public void setQPuntosxReporte(int qPuntosxReporte) {
		QPuntosxReporte = qPuntosxReporte;
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

	public Usuario getObjusuario() {
		return Objusuario;
	}

	public void setObjusuario(Usuario objusuario) {
		Objusuario = objusuario;
	}

	public Direccion getObjdireccion() {
		return Objdireccion;
	}

	public void setObjdireccion(Direccion objdireccion) {
		Objdireccion = objdireccion;
	}


	
}
