package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Distrito;

public interface IDistritoService {
	public boolean grabar(Distrito distrito);
	public void eliminar(int idDistrito);
	public Optional<Distrito> listarId(int idDistrito);
	public List<Distrito> listar();	
}
