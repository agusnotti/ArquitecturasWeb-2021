package rest;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class LectorCicloDeVida implements ServletContextListener {

	public static String EMF = null;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextInitialized(sce);
		System.out.println("aca iniciaria EMF");
		EMF = "EMF creado";
		// aca inicio mi EMF
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
		System.out.println("aca cerraria EMF");
		// aca cierro mi EMF
	}
	
}
