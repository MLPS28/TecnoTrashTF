package pe.edu.upc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Distrito;

@Repository							   //<sobre que entidad, El primary key(el cual es int este caso se pone integer)>
public interface IDistritoRepository extends JpaRepository<Distrito, Integer>{ //gracias a Extends, iracerepository puede hacer uso de las operaciones de jpare
}
