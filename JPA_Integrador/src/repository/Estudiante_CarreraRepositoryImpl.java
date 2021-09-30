package repository;

import entities.Estudiante_Carrera;

import javax.persistence.EntityManager;

public class Estudiante_CarreraRepositoryImpl implements Estudiante_CarreraRepository {

	private EntityManager em;
	
	
	public Estudiante_CarreraRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Estudiante_Carrera getEstudianteCarreraById(Long id) {
		return em.find(Estudiante_Carrera.class, id);
	}

	@Override
	public Estudiante_Carrera saveEstudianteCarrera(Estudiante_Carrera ec) {
		if (ec.getId() == null) {
			em.persist(ec);
		} else {
			ec = em.merge(ec);
		}
		return ec;
	}

	@Override
	public void deleteEstudianteCarrera(Estudiante_Carrera ec) {
		if (em.contains(ec)) {
			em.remove(ec);
		} else {
			em.merge(ec);
		}
		
	}

}
