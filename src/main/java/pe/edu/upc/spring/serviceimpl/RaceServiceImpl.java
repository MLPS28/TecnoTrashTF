package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Race;
import pe.edu.upc.spring.repository.IRaceRepository;
import pe.edu.upc.spring.service.IRaceService;

@Service
public class RaceServiceImpl implements IRaceService {

	@Autowired //ya no es inject
	private IRaceRepository dRace;  //drace: objeto o representacion de IRaceRepository
	
	@Override
	@Transactional //los que no impliquen listados solo seran de tipo transactional
	public boolean grabar(Race race) {
		Race objRace = dRace.save(race);
		if (objRace == null)
			return false;
		else
			return true;
	}

	

	@Override
	@Transactional
	public void eliminar(int idRace) {
		dRace.deleteById(idRace); //solo necesita el id que se desea eliminar
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Race> listarId(int idRace) {
		return dRace.findById(idRace);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Race> listar() {
		return dRace.findAll(); //devuelve todo en una lista
	}

	@Override
	@Transactional(readOnly = true)
	public List<Race> buscarNombre(String nameRace) {
		return dRace.buscarNombre(nameRace); //esto es el único método propio que se hico en IRepository
	}

}
