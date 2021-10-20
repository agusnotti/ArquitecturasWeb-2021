package repository;

import entities.Carrera;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


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
	
	@Override
	public void insertarDesdeCSV(CSVParser csv) {
		for(CSVRecord row: csv) {
			String nombre = row.get("nombre");
			
			System.out.println(row.get("nombre"));
			
			Carrera c = new Carrera(nombre);
			try {
				this.saveCarrera(c);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}

	//recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
	@Override
	public List<Carrera> getCarrerasConEstudiantes(){
		Query q = em.createQuery("SELECT c.nombre,count(e) as contador FROM Carrera c "
				+ "JOIN c.estudiantes e "
				+ "WHERE c.estudiantes IS NOT EMPTY "
				+ "GROUP BY c.nombre "
				+ "ORDER BY contador DESC"
			);
		return q.getResultList();

	}


	public List<Object> getReporteCarrera(){


		Query q = em.createNativeQuery("select nombre, anio, sum(inscriptos) inscriptos, sum(graduados) graduados from(" +
				"SELECT nombre, year(fechaInscripcion) anio, count(estudiante_id) as inscriptos, '0' as graduados " +
				"from Carrera c inner join  Estudiante_Carrera ec on carrera_id= c.id group by carrera_id,anio " +
				"union " +
				"SELECT nombre, year(fechaGraduacion) anio,  '0' as inscriptos, count(estudiante_id) as graduados " +
				"from Carrera c inner join  Estudiante_Carrera ec on carrera_id= c.id where fechaGraduacion is not null group by carrera_id,anio order by nombre,anio) a " +
				" group by nombre, anio;");
		return q.getResultList();

	}

}
