package es.jcyl.educa.javaee.comun.api;

import es.jcyl.educa.javaee.comun.modelo.Localidad;
import es.jcyl.educa.javaee.comun.servicio.LocalidadServicio;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestScoped
@Path("/localidades")
public class LocalidadApi {

	@Inject
	private LocalidadServicio localidadServicio;

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public GenericEntity<List<Localidad>> localidades(
		@QueryParam("provinciaId") Integer provinciaId,
		@QueryParam("municipioId") Integer municipioId) {

		List<Localidad> localidades =
			provinciaId == null || municipioId == null ?
				localidadServicio.localidades() :
				localidadServicio.localidades(provinciaId, municipioId);
		return new GenericEntity<List<Localidad>>(
			localidades) {
		};
	}

}
