package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Autoridad;
import pe.edu.upc.spring.repository.IAutoridadRepository;
import pe.edu.upc.spring.service.IAutoridadService;

@Service
public class AutoridadServiceImpl implements IAutoridadService {

	@Autowired //envez del inject
	private IAutoridadRepository dAutoridad;  //dpremio: objeto o representacion de IPremioRepository
	
	@Override
	@Transactional //los que no impliquen listados solo seran de tipo transactional
	public boolean grabar(Autoridad autoridad) {
		Autoridad objAutoridad = dAutoridad.save(autoridad);
		if (objAutoridad == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int CAutidad) {
		dAutoridad.deleteById(CAutidad); //solo necesita el id que se desea eliminar
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Autoridad> listarId(int CAtoridad) {
		return dAutoridad.findById(CAtoridad);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Autoridad> listar() {
		return dAutoridad.findAll(); //devuelve todo en una lista
	}

}
