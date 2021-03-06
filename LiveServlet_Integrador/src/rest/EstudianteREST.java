package rest;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Estudiante;
import entities.Estudiante_Carrera;
import repository.CarreraRepository;
import repository.CarreraRepositoryImpl;
import repository.EstudianteRepository;
import repository.EstudianteRepositoryImpl;
import repository.Estudiante_CarreraRepository;
import repository.Estudiante_CarreraRepositoryImpl;

@Path("/estudiantes")
public class EstudianteREST {

	public static EntityManager em = LectorCicloDeVida.EM;


	//a) dar de alta un estudiante
		@POST
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.APPLICATION_JSON)
		public Response AddEstudiante(@FormParam("nombre") String nombre, 
									@FormParam("apellido") String apellido, 
									@FormParam("edad") int edad,
									@FormParam("genero") char genero,
									@FormParam("dni") int dni,
									@FormParam("ciudadResidencia") String ciudadResidencia,
									@FormParam("libretaUniversitaria") int libretaUniversitaria) {
			
			Estudiante e = new Estudiante(nombre, apellido, edad, genero, dni, ciudadResidencia, libretaUniversitaria);
			
			em.getTransaction().begin();
			
			EstudianteRepository estudianteRepo = new EstudianteRepositoryImpl(em);
			Estudiante estudiante = estudianteRepo.saveEstudiante(e);

			em.getTransaction().commit();
			System.out.println(estudiante);


			return Response.status(201).entity(e).build();
		}
	//b matricular un estudiante en una carrera
	@POST
	@Path("/matricular")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response matricularEstudiante(@FormParam("id-carrera") Long idCarrera,
										@FormParam("id-estudiante") Long idEstudiante ) {

			em.getTransaction().begin();
			

			Estudiante_CarreraRepository estudianteCarreraRepo = new Estudiante_CarreraRepositoryImpl(em);
			EstudianteRepository er = new EstudianteRepositoryImpl(em);
			CarreraRepository cr = new CarreraRepositoryImpl(em);
			Estudiante_Carrera ec = new Estudiante_Carrera(er.getEstudianteById(idEstudiante), cr.getCarreraById(idCarrera), null, new Timestamp(System.currentTimeMillis()));
			estudianteCarreraRepo.saveEstudianteCarrera(ec);

			em.getTransaction().commit();

			return Response.status(201).entity(ec).build();
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
	
	
	//d) recuperar un estudiante, en base a su n?mero de libreta universitaria.
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
		

	//e) recuperar todos los estudiantes, en base a su g?nero.
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
