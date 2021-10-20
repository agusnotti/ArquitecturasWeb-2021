package rest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Estudiante;
import repository.CarreraRepository;
import repository.CarreraRepositoryImpl;
import repository.EstudianteRepository;
import repository.EstudianteRepositoryImpl;

@Path("/carreras")
public class CarreraREST {

	public static EntityManager em = LectorCicloDeVida.EM;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuario(@PathParam("id")int id) {
		return new Usuario(id, "Nombre_"+id, "Apellido_"+id);
	}
	
	@GET
	@Path("/estudiantes")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Object getCarrerasConEstudiantes() {
		CarreraRepository cr = new CarreraRepositoryImpl(em);
		return cr.getCarrerasConEstudiantes();
	}
	
	@GET
	@Path("/reporte")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getReporteCarrera() {
	
		CarreraRepository cr = new CarreraRepositoryImpl(em);
		return cr.getReporteCarrera();
	}
	
	
}
