package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Direccion")
public class Direccion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CDireccion", nullable = false)
	private int CDireccion;
	
	@Column(name = "NDireccion", nullable = false, length = 60)
	private String NDireccion;
	
	@Column(name = "NumDireccion", nullable = false)
	private int NumDireccion;
	
	@ManyToOne
	@JoinColumn(name = "CDistrito")
	private Distrito Objdistrito;
	
	@ManyToOne
	@JoinColumn(name = "CTipoVia")
	private TipoVia ObjtipoVia;

	public Direccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Direccion(int cDireccion, String nDireccion, int numDireccion, pe.edu.upc.spring.model.Distrito objdistrito,
			pe.edu.upc.spring.model.TipoVia objtipoVia) {
		super();
		CDireccion = cDireccion;
		NDireccion = nDireccion;
		NumDireccion = numDireccion;
		Objdistrito = objdistrito;
		ObjtipoVia = objtipoVia;
	}

	public int getCDireccion() {
		return CDireccion;
	}

	public void setCDireccion(int cDireccion) {
		CDireccion = cDireccion;
	}

	public String getNDireccion() {
		return NDireccion;
	}

	public void setNDireccion(String nDireccion) {
		NDireccion = nDireccion;
	}

	public int getNumDireccion() {
		return NumDireccion;
	}

	public void setNumDireccion(int numDireccion) {
		NumDireccion = numDireccion;
	}

	public Distrito getObjdistrito() {
		return Objdistrito;
	}

	public void setObjdistrito(Distrito objdistrito) {
		Objdistrito = objdistrito;
	}

	public TipoVia getObjtipoVia() {
		return ObjtipoVia;
	}

	public void setObjtipoVia(TipoVia objtipoVia) {
		ObjtipoVia = objtipoVia;
	}
	
	
}
