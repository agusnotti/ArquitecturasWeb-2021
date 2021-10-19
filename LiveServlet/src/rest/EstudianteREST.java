package rest;

import java.util.List;

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

	// a) dar de alta un estudiante
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

	// b) matricular un estudiante en una carrera
	@POST
	@Path("/matricular")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response matricularEstudiante(Estudiante_Carrera ec) {

		System.out.println(ec);
		
		Estudiante_CarreraRepository estudianteCarreraRepo = new Estudiante_CarreraRepositoryImpl(em);
		estudianteCarreraRepo.saveEstudianteCarrera(ec);

		em.getTransaction().commit();
		System.out.println(ec);

		return Response.status(201).entity(ec).build();
	}

	// c) recuperar todos los estudiantes, y especificar algun criterio de
	// ordenamiento simple.
	@GET
	@Path("/edades")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> getEstudiantesPorEdad() {

		EstudianteRepository estudianteRepo = new EstudianteRepositoryImpl(em);
		List<Estudiante> estudiantes = estudianteRepo.getEstudiantesOrdenadosPorEdad();

		System.out.println(estudiantes);

		return estudiantes;
	}

	// d) recuperar un estudiante, en base a su número de libreta universitaria.
	@GET
	@Path("/libreta/{numLibreta}")
	@Produces(MediaType.APPLICATION_JSON)
	public Estudiante getEstudiantes(@PathParam("numLibreta") int numLibreta) {

		EstudianteRepository estudianteRepo = new EstudianteRepositoryImpl(em);
		Estudiante estudiante = estudianteRepo.getEstudianteByNumeroLibreta(numLibreta);

		System.out.println(estudiante);

		return estudiante;
	}

	// e) recuperar todos los estudiantes, en base a su género.
	@GET
	@Path("/genero/{g}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estudiante> getEstudiantesPorGenero(@PathParam("g") char genero) {

		EstudianteRepository estudianteRepo = new EstudianteRepositoryImpl(em);
		List<Estudiante> estudiantes = estudianteRepo.getEstudiantesByGenero(genero);
		System.out.println(estudiantes);

		return estudiantes;
	}

	@GET
	@Path("/{id}/{ciudad}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getEstudiantesDeCarreraYciudad(@PathParam("id") Long id, @PathParam("ciudad") String ciudad) {

		EstudianteRepository estudianteRepo = new EstudianteRepositoryImpl(em);
		CarreraRepository carreraRepo = new CarreraRepositoryImpl(em);
		entities.Carrera c = carreraRepo.getCarreraById(id);

		return estudianteRepo.getEstudiantesDeCarreraYciudad(c, "Tandil");
	}

}
