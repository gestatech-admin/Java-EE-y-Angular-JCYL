package es.jcyl.educa.javaee.alumnos.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import es.jcyl.educa.javaee.alumnos.modelo.Alumno;
import es.jcyl.educa.javaee.alumnos.servicio.AlumnosServicio;

@Path("/alumnos")
public class AlumnosApi {

	@Inject
	AlumnosServicio alumnosServicio;

	@Context
	private UriInfo uriInfo;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response lista(@QueryParam(value = "page") Integer page) {
		final List<Alumno> alumnos = alumnosServicio.getAlumnos(page);

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
