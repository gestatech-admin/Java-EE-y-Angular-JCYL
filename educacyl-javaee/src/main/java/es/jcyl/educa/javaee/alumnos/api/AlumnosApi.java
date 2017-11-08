package es.jcyl.educa.javaee.alumnos.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.jcyl.educa.javaee.alumnos.modelo.Alumno;
import es.jcyl.educa.javaee.alumnos.servicio.AlumnosServicio;

@Path("/alumnos")
public class AlumnosApi {

	@Inject
	AlumnosServicio alumnosServicio;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response lista() {
		final List<Alumno> alumnos = alumnosServicio.getAlumnos();

		GenericEntity<List<Alumno>> list = new GenericEntity<List<Alumno>>(alumnos) {
		};
		return Response.ok(list).build();
	}

	@GET
	@Path("/centro/{centroId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listaDeUnCentro(@PathParam("centroId") Long centroId) {
		final List<Alumno> alumnos = alumnosServicio.getAlumnosDeUnCentro(centroId);

		GenericEntity<List<Alumno>> list = new GenericEntity<List<Alumno>>(alumnos) {
		};
		return Response.ok(list).build();
	}

}
