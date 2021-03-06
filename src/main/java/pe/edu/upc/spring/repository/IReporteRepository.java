package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Reporte;

@Repository						   //<sobre que entidad, El primary key(el cual es int este caso se pone integer)>
public interface IReporteRepository extends JpaRepository<Reporte, Integer>{ //gracias a Extends, iracerepository puede hacer uso de las operaciones de jpare
	
	@Query("from Reporte r where r.direccion.NDireccion like %:NDireccion%")
	List<Reporte> buscarDireccionReporte(@Param("NDireccion") String NDireccion);
}
