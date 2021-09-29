package repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Carrera;

public class CarreraRepositoryImpl implements CarreraRepository {

	private EntityManager em;

	public CarreraRepositoryImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public Carrera getCarreraById(Long id) {
		return em.find(Carrera.class, id);
	}

	@Override
	public Carrera getCarreraByName(String name) {
		// es createQuery?
		TypedQuery<Carrera> q = em.createQuery("SELECT b FROM Carrera c WHERE c.nombre = :nombre", Carrera.class);
		q.setParameter("nombre", name);
		return q.getSingleResult();
	}

	@Override
	public Carrera saveCarrera(Carrera c) {
		if (c.getId() == null) {
			em.persist(c);
		} else {
			c = em.merge(c);
		}
		return c;
	}

	@Override
	public void deleteCarrera(Carrera c) {
		if (em.contains(c)) {
			em.remove(c);
		} else {
			em.merge(c);
		}
	}

}
