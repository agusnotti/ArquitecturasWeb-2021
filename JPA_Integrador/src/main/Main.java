package main;

import entities.*;
import repository.CarreraRepository;
import repository.CarreraRepositoryImpl;
import repository.EstudianteRepository;
import repository.EstudianteRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import helpers.Helpers;
import repository.*;

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
		estudianteCarreraRepo.insertarDesdeCSV(Helpers.leerCSV("csv/estudiantes_carreras.csv"));
		

		em.getTransaction().commit();
		
		em.close();
		emf.close();
		

	}

}
