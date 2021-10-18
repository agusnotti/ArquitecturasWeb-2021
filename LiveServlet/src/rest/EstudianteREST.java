package rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Estudiante;
import repository.EstudianteRepository;
import repository.EstudianteRepositoryImpl;

@Path("/estudiantes")
public class EstudianteREST {

	public static EntityManager em = LectorCicloDeVida.EM;
	
	@GET
	@Path("/libreta/{numLibreta}")
	@Produces(MediaType.APPLICATION_JSON)
	public Estudiante getUsuarios(@PathParam("numLibreta")int numLibreta){
		
		em.getTransaction().begin();
		
		EstudianteRepository estudianteRepo = new EstudianteRepositoryImpl(em);
		Estudiante estudiante = estudianteRepo.getEstudianteByNumeroLibreta(numLibreta);
		
		em.getTransaction().commit();
		System.out.println(estudiante);
		
		return estudiante;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuario(@PathParam("id")int id) {
		return new Usuario(id, "Nombre_"+id, "Apellido_"+id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response AddUsuario(Estudiante e) {
		em.getTransaction().begin();
		
		EstudianteRepository estudianteRepo = new EstudianteRepositoryImpl(em);
		Estudiante estudiante = estudianteRepo.saveEstudiante(e);
		
		em.getTransaction().commit();
		System.out.println(estudiante);
		
		
		return Response.status(201).entity(e).build();
	}
}
