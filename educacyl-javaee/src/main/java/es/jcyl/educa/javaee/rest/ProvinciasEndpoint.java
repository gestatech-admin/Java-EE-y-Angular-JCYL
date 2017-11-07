package es.jcyl.educa.javaee.rest;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import es.jcyl.educa.javaee.model.Provincia;
import es.jcyl.educa.javaee.service.ProvinciasServicio;

@Path("/provincias")
public class ProvinciasEndpoint {

	@Inject
	ProvinciasServicio provinciasServicio;

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response buscarPorId(@PathParam("id") Integer id) {
		try {
			Provincia provincia = provinciasServicio.buscarPorId(id);
			return Response.ok(provincia).build();
		} catch (NoResultException nre) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response lista() {
		final ArrayList<Provincia> provincias = (ArrayList<Provincia>) provinciasServicio.getProvincias();

		GenericEntity<ArrayList<Provincia>> list = new GenericEntity<ArrayList<Provincia>>(provincias) {
		};
		return Response.ok(list).build();
	}

}
