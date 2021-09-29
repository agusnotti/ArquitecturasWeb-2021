package repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Estudiante;

public class EstudianteRepositoryImpl implements EstudianteRepository {

	private EntityManager em;

	public EstudianteRepositoryImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public Estudiante getEstudianteById(Long id) {
		return em.find(Estudiante.class, id);
	}

	@Override
	public Estudiante getEstudianteByNumeroLibreta(String numLibreta) {
		// es createQuery?
		TypedQuery<Estudiante> q = em.createQuery("SELECT e FROM Estudiante e WHERE c.libretaUniversitaria = :libretaUniversitaria", Estudiante.class);
		q.setParameter("libretaUniversitaria", numLibreta);
		return q.getSingleResult();
	}

	@Override
	public Estudiante saveEstudiante(Estudiante c) {
		if (c.getId() == null) {
			em.persist(c);
		} else {
			c = em.merge(c);
		}
		return c;
	}

	@Override
	public void deleteEstudiante(Estudiante c) {
		if (em.contains(c)) {
			em.remove(c);
		} else {
			em.merge(c);
		}
	}

}
