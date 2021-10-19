package rest;

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

@Path("/estudiantes")
public class EstudianteREST {

	public static EntityManager em = LectorCicloDeVida.EM;


	//a) dar de alta un estudiante
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response AddEstudiante(Estudiante e) {

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

		EstudianteRepository estudianteRepo = new EstudianteRepositoryImpl(em);

		List <Estudiante> estudiantes = estudianteRepo.getEstudiantesOrdenadosPorEdad();

		em.getTransaction().commit();
		System.out.println(estudiantes);

		return estudiantes;
	}
	
	
	//d) recuperar un estudiante, en base a su número de libreta universitaria.
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
		

	//e) recuperar todos los estudiantes, en base a su género.
	@GET
	@Path("/genero/{g}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> getEstudiantesPorGenero(@PathParam("g")char genero){

		EstudianteRepository estudianteRepo = new EstudianteRepositoryImpl(em);
		List <Estudiante> estudiantes = estudianteRepo.getEstudiantesByGenero(genero);
		System.out.println(estudiantes);

		return estudiantes;
	}	


	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuario(@PathParam("id")int id) {
		return new Usuario(id, "Nombre_"+id, "Apellido_"+id);
	}



	

	
	@GET
	@Path("/{id}/{ciudad}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getEstudiantesDeCarreraYciudad(@PathParam("id")Long id,@PathParam("ciudad") String ciudad) {

		
		EstudianteRepository estudianteRepo = new EstudianteRepositoryImpl(em);
		CarreraRepository carreraRepo = new CarreraRepositoryImpl(em);
		entities.Carrera c = carreraRepo.getCarreraById(id);

		
		return estudianteRepo.getEstudiantesDeCarreraYciudad(c,"Tandil");
	}
	
	
}
