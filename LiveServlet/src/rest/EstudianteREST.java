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


	//a) dar de alta un estudiante
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
	
	
	
	//c) recuperar todos los estudiantes, y especificar algun criterio de ordenamiento simple.
	@GET 
	@Path("/edades")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> getEstudiantesPorEdad(){
		em.getTransaction().begin();

		EstudianteRepository estudianteRepo = new EstudianteRepositoryImpl(em);
		List <Estudiante> estudiantes = estudianteRepo.getEstudiantesOrdenadosPorEdad();

		em.getTransaction().commit();
		System.out.println(estudiantes);

		return estudiantes;
	}
	
	
	//d) recuperar un estudiante, en base a su n�mero de libreta universitaria.
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
		

	//e) recuperar todos los estudiantes, en base a su g�nero.
	@GET
	@Path("/genero/{g}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> getEstu(@PathParam("g")char genero){

		em.getTransaction().begin();

		EstudianteRepository estudianteRepo = new EstudianteRepositoryImpl(em);
		List <Estudiante> estudiantes = estudianteRepo.getEstudiantesByGenero(genero);

		em.getTransaction().commit();
		System.out.println(estudiantes);

		return estudiantes;
	}	


	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuario(@PathParam("id")int id) {
		return new Usuario(id, "Nombre_"+id, "Apellido_"+id);
	}



	


}
