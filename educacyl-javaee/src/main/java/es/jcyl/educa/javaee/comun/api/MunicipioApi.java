package es.jcyl.educa.javaee.comun.api;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.jcyl.educa.javaee.comun.modelo.Municipio;
import es.jcyl.educa.javaee.comun.servicio.MunicipioServicio;

@Path("/municipios")
@RequestScoped
public class MunicipioApi {

	@Inject
	MunicipioServicio municipioServicio;

	@GET
	@Path("/")
	public Municipio find(@QueryParam("municipioId") Long municipioId,
			@QueryParam("provinciaId") Long provinciaId) {

		return municipioServicio.getMunicipio(municipioId, provinciaId);
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response findAll(@QueryParam("provinciaId") Long provinciaId) {

		final List<Municipio> municipios = provinciaId == null ? municipioServicio.getMunicipios()
				: municipioServicio.getMunicipios(provinciaId);

		GenericEntity<List<Municipio>> list = new GenericEntity<List<Municipio>>(municipios) {
		};
		return Response.ok(list).build();
	}

}
