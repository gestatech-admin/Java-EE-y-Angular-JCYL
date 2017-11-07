package es.jcyl.educa.javaee.rest;

import java.net.URI;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import es.jcyl.educa.javaee.model.Centro;
import es.jcyl.educa.javaee.service.CentrosServicio;

@Path("/centros")
@RequestScoped
public class CentrosEndpoint {

	@Inject
	CentrosServicio centrosServicio;

	@POST
	@Consumes("application/json")
	public Response crear(Centro centro) {
		centrosServicio.crear(centro);
		URI url = UriBuilder.fromResource(CentrosEndpoint.class).path(String.valueOf(centro.getId())).build();
		return Response.created(url).build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	@RestSecured
	public Response eliminar(@PathParam("id") Integer id) {
		Centro centro = centrosServicio.buscarPorId(id);
		if (centro == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		centrosServicio.eliminar(centro);
		return Response.noContent().build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response buscarPorId(@PathParam("id") Integer id) {
		try {
			Centro centro = centrosServicio.buscarPorId(id);
			return Response.ok(centro).build();
		} catch (NoResultException nre) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response lista() {
		final List<Centro> centros = centrosServicio.getCentros();

		GenericEntity<List<Centro>> list = new GenericEntity<List<Centro>>(centros) {
		};
		return Response.ok(list).header("total", centrosServicio.total()).build();
	}

	@GET
	@Path("total")
	public Response total() {
		return Response.ok(centrosServicio.total()).build();
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	public Response update(@PathParam("id") Long id, Centro centro) {
		if (centro == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if (!id.equals(centro.getId())) {
			return Response.status(Status.CONFLICT).entity(centro).build();
		}
		try {
			centrosServicio.actualizar(centro);
		} catch (Exception e) {
			return Response.status(Status.CONFLICT).entity(centro).build();
		}
		return Response.noContent().build();
	}

}
