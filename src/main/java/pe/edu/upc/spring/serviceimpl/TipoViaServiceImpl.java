package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.TipoVia;
import pe.edu.upc.spring.repository.ITipoViaRepository;
import pe.edu.upc.spring.service.ITipoViaService;

@Service
public class TipoViaServiceImpl implements ITipoViaService {

	@Autowired //ya no es inject
	private ITipoViaRepository dTipovia;  //drace: objeto o representacion de IRaceRepository
	
	@Override
	@Transactional //los que no impliquen listados solo seran de tipo transactional
	public boolean grabar(TipoVia tipovia) {
		TipoVia objTipoVia = dTipovia.save(tipovia);
		if (objTipoVia == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int idTipoVia) {
		dTipovia.deleteById(idTipoVia); //solo necesita el id que se desea eliminar
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TipoVia> listarId(int idTipoVia) {
		return dTipovia.findById(idTipoVia);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoVia> listar() {
		return dTipovia.findAll(); //devuelve todo en una lista
	}

}
