package rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class LectorCicloDeVida implements ServletContextListener {

	public static EntityManagerFactory EMF = null;
	public static EntityManager EM = null;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContextListener.super.contextInitialized(sce);
		System.out.println("inicio EM");
		EMF = Persistence.createEntityManagerFactory("Jpa-Estudiantes");
		EM = EMF.createEntityManager();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
		System.out.println("cierro EM");
		EM.close();
		EMF.close();
	}
	
}
