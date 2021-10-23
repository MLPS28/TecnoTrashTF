package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.TipoVia;

public interface ITipoViaService {
	public boolean grabar(TipoVia tipovia);
	
	public void eliminar(int idTipoVia);
	public Optional<TipoVia> listarId(int idTipoVia);
	public List<TipoVia> listar();	
}
