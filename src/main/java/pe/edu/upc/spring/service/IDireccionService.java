package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Direccion;

public interface IDireccionService {
	public boolean grabar(Direccion direccion);
	public void eliminar(int CDireccion);
	public Optional<Direccion> listarId(int CDireccion);
	public List<Direccion> listar();	
}
