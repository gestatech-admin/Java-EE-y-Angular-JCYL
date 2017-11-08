package es.jcyl.educa.javaee.comun.api;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.jcyl.educa.javaee.comun.modelo.Localidad;
import es.jcyl.educa.javaee.comun.servicio.LocalidadServicio;

@Path("/localidades")
@RequestScoped
public class LocalidadApi {

	@Inject
	LocalidadServicio localidadServicio;

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response findAll() {

		final List<Localidad> localidades = localidadServicio.localidades();

		GenericEntity<List<Localidad>> list = new GenericEntity<List<Localidad>>(localidades) {
		};
		return Response.ok(list).build();
	}

}
