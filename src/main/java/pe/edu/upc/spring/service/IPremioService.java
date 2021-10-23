package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Premio;

public interface IPremioService {
	public boolean grabar(Premio premio);
	
	public void eliminar(int idPremio);
	public Optional<Premio> listarId(int idPremio);
	public List<Premio> listar();
}
