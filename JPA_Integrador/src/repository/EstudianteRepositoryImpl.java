package repository;

import entities.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.List;

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
	public Estudiante getEstudianteByNumeroLibreta(int numLibreta) {
		// es createQuery?
		TypedQuery<Estudiante> q = em.createQuery("SELECT e FROM Estudiante e WHERE e.libretaUniversitaria = :libretaUniversitaria", Estudiante.class);
		q.setParameter("libretaUniversitaria", numLibreta);
		return q.getSingleResult();
	}
	
	@Override
	public List<Estudiante> getEstudiantesOrdenadosPorEdad(){
		Query que = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.edad", Estudiante.class);
		@SuppressWarnings("unchecked")
		List<Estudiante> list = que.getResultList();
		return list;
	}
	
	@Override
	public List<Estudiante> getEstudiantesByGenero(char genero){
		Query que = em.createQuery("SELECT e FROM Estudiante e WHERE e.genero = :genero", Estudiante.class);
		que.setParameter("genero", genero);
		@SuppressWarnings("unchecked")
		List<Estudiante> list = que.getResultList();
		return list;
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
	
	@Override
	public void insertarDesdeCSV(CSVParser csv) {
		for(CSVRecord row: csv) {

			String nombre = row.get("nombre");
			String apellido = row.get("apellido");
			int edad = Integer.parseInt(row.get("edad"));
			char genero = row.get("genero").charAt(0);
			int dni = Integer.parseInt(row.get("dni"));
			String ciudadResidencia = row.get("ciudadResidencia");
			int libretaUniversitaria = Integer.parseInt(row.get("libretaUniversitaria"));
			
			
			System.out.println(row.get("nombre")+", "+row.get("apellido"));
			
			Estudiante es = new Estudiante(nombre, apellido, edad, genero, dni, ciudadResidencia, libretaUniversitaria);
			try {
				this.saveEstudiante(es);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}


}
