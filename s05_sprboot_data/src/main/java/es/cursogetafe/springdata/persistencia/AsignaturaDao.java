package es.cursogetafe.springdata.persistencia;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import es.cursogetafe.springdata.modelo.Asignatura;
import es.cursogetafe.springdata.modelo.Profesor;

public interface AsignaturaDao extends JpaRepository<Asignatura, Integer> {

	@Query("select a from Asignatura a where a.profesor is null")
	Set<Asignatura> buscarSinProfesor();
	
//	@NativeQuery("select * from asignaturas left join alumnos on ...)
	@Query("select a from Asignatura a where a.asignatura like %?1%")
	Set<Asignatura> buscarPorDescripcion(String desc);
	
	Set<Asignatura> findByProfesor(Profesor profe);
	
	Set<Asignatura> findByFacultadLike(String facultad);

	default Map<Integer, Asignatura> buscarTodas(){
		Map<Integer, Asignatura> resu = new HashMap<Integer, Asignatura>();
		for (Asignatura asig : findAll()) {
			resu.put(asig.getIdAsignatura(), asig);
		}
		return resu;
	}
	
	
	
	@Query("select a from Asignatura a left join fetch a.alumnos where a.idAsignatura = ?1")
	Optional<Asignatura> findByIdEager(Integer id);
	
	public default Optional<Asignatura> findById(Integer id){
		return findByIdEager(id);
	}
	
//	@Query("select a from Asignatura a left join fetch a.alumnos where a.idAsignatura = ?1")
//	Asignatura findByIdEager(Integer id);
//	
//	public default Optional<Asignatura> findById(Integer id){
//		Asignatura buscada = findByIdEager(id);
//		if (buscada != null)
//			return Optional.of(buscada);
//		else
//			return Optional.empty();
//	}
}
