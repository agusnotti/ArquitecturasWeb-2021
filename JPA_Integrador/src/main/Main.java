package main;

import entities.Estudiante;
import repository.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa-Estudiantes");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();

		CarreraRepository carreraRepo = new CarreraRepositoryImpl(em);
		EstudianteRepository estudianteRepo = new EstudianteRepositoryImpl(em);
		Estudiante_CarreraRepository estudianteCarreraRepo = new Estudiante_CarreraRepositoryImpl(em);
		
//		carreraRepo.insertarDesdeCSV(Helpers.leerCSV("csv/carreras.csv"));
//		estudianteRepo.insertarDesdeCSV(Helpers.leerCSV("csv/estudiantes.csv"));
//		estudianteCarreraRepo.insertarDesdeCSV(Helpers.leerCSV("csv/estudiantes_carreras.csv"));
		

//		a) dar de alta un estudiante
		Estudiante e = new Estudiante("nombre", "apellido", 23, 'm', 2343, "tandil", 12234);
		estudianteRepo.saveEstudiante(e);
		
//		b) matricular un estudiante en una carrera
		
		
//		c) recuperar todos los estudiantes, y especificar alg�n criterio de ordenamiento simple.
//		System.out.println(estudianteRepo.getEstudiantesOrdenadosPorEdad());
		
//		d) recuperar un estudiante, en base a su n�mero de libreta universitaria.
//		System.out.println(estudianteRepo.getEstudianteByNumeroLibreta(44));
		
//		e) recuperar todos los estudiantes, en base a su g�nero.
//		System.out.println(estudianteRepo.getEstudiantesByGenero('f'));
		
//		f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.

		List x = carreraRepo.getCarrerasConEstudiantes();
		for(Object o : x) {
			Object[] y = (Object[])o;
			System.out.printf("%s %s\n", y[0], y[1]);
		}

//		g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
		System.out.println();
		
		
		
				
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		

	}

}
