package es.jcyl.educa.javaee.comun.api;

import es.jcyl.educa.javaee.comun.modelo.Municipio;
import es.jcyl.educa.javaee.comun.servicio.MunicipioServicio;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/municipios")
@RequestScoped
public class MunicipioApi {

	@Inject
	MunicipioServicio municipioServicio;

	@GET
	@Path("/")
	public Municipio find(
		@QueryParam("municipioId") Integer municipioId,
		@QueryParam("provinciaId") Integer provinciaId) {

		return municipioServicio.getMunicipio(municipioId, provinciaId);
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public GenericEntity<List<Municipio>> findAll(
		@QueryParam("provinciaId") Integer provinciaId) {

		final List<Municipio> municipios =
			provinciaId == null ? municipioServicio.getMunicipios()
				: municipioServicio.getMunicipios(provinciaId);

		return new GenericEntity<List<Municipio>>(municipios) {
		};
	}

}
