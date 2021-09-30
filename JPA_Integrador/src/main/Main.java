package main;

import entities.Carrera;
import entities.Estudiante;
import repository.CarreraRepository;
import repository.CarreraRepositoryImpl;
import repository.EstudianteRepository;
import repository.EstudianteRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa-Estudiantes");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();



		CarreraRepository cr = new CarreraRepositoryImpl(em);
		Carrera econ = new Carrera("Economicas");
		cr.saveCarrera(econ);

		EstudianteRepository er = new EstudianteRepositoryImpl(em);

		Estudiante e1 = new Estudiante("Geronimo", "Anselmo" , 31, 'M', 35334404,"Olavarria",
		256644) ;

//		e1.setCarreras(new ArrayList<Estudiante_Carrera>(econ));
//		er.saveEstudiante()

		System.out.println(cr.getCarrerasConEstudiantes());


		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
