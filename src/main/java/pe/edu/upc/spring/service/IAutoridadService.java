package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Autoridad;

public interface IAutoridadService {
	public boolean grabar(Autoridad autoridad);
	public void eliminar(int CAutoridad);
	public Optional<Autoridad> listarId(int CAutoridad);
	public List<Autoridad> listar();
}
