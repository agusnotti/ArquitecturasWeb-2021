package rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/usuarios")
public class UsuarioREST {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuarios(){
		// obtengo el EMF del lector de ciclo de vida
		System.out.println(LectorCicloDeVida.EMF);
		return IntStream.
				range(0,20).
				mapToObj(i -> new Usuario(i, "Nombre_"+i, "Apellido_"+i)).
				collect(Collectors.toList());
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
	public String AddUsuario(Usuario u) {
		System.out.println("agregando "+ u);
		return "el usuario se agrego correctamente";
	}
}
