package es.jcyl.educa.javaee.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.jcyl.educa.javaee.model.Alumno;
import es.jcyl.educa.javaee.service.AlumnosServicio;

@Path("/alumnos")
public class AlumnosEndpoint {

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

}
