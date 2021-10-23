package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.UsuarioPremio;

public interface IUsuarioPremioService {
	public boolean grabar(UsuarioPremio CUsuarioPremio);
	public void eliminar(int CUsuarioPremio);
	public Optional<UsuarioPremio> listarId(int CUsuarioPremio);
	public List<UsuarioPremio> listar();	
}
