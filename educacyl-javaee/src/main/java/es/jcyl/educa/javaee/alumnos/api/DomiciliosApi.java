package es.jcyl.educa.javaee.alumnos.api;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import es.jcyl.educa.javaee.alumnos.modelo.Alumno;
import es.jcyl.educa.javaee.alumnos.modelo.Domicilio;
import es.jcyl.educa.javaee.centros.modelo.Centro;
import es.jcyl.educa.javaee.comun.modelo.Personal;

@Path("/domicilios")
public class DomiciliosApi {

	@GET
	public Response getDomicilios() {

		Centro centro = getCentro();

		centro.getListaPersonal();

		// System.out.println(personal.getCentro().getNombre());

		// List empleados =
		// entityManager.unwrap(Session.class).createCriteria(Personal.class).list();

		// Session session = entityManager.unwrap(Session.class);
		//
		// List personal = session.createCriteria(Personal.class).list();
		//
		// GenericEntity<List<Domicilio>> list = new GenericEntity<List<Domicilio>>(
		// datosUsuario.getDomicilios()) {
		// };
		//
		// if (!datosUsuario.esLogueado()) {
		// datosUsuario.setLogueado(true);
		// }

		// return Response.ok(list).build();
		return Response.ok().build();
	}

	@Transactional
	private Centro getCentro() {
		Centro fernandoDeRojas = new Centro();

		Alumno alumno = new Alumno();

		Domicilio domicilio = new Domicilio();
		alumno.getDomicilios().add(domicilio);
		domicilio.setAlumno(alumno);

		Personal juanGarcia = new Personal("Juan", "Garcia", null, 40L);

		entityManager.persist(juanGarcia);

		Centro centro = entityManager.find(Centro.class, 40000550L);

		return centro;
	}

	@PersistenceContext
	private EntityManager entityManager;

	@GET
	@Path("/{calle}")
	public Domicilio getDomicilio(@PathParam("calle") String calle) {

		return datosUsuario.getDomicilios().stream()
				.filter(domicilio -> calle.equals(domicilio.getNombre())).findFirst().get();
	}

	@POST
	@Consumes("application/json")
	public Domicilio addDomicilio(Domicilio domicilio) {

		datosUsuario.getDomicilios().add(domicilio);

		return domicilio;
	}

	@DELETE
	@Path("/{calle}")
	public Response removeDomicilio(@PathParam("calle") String calle) {

		Domicilio domicilioAEliminar = null;

		for (Domicilio domicilio : datosUsuario.getDomicilios()) {
			if (domicilio.getNombre().equals(calle)) {
				domicilioAEliminar = domicilio;
			}
		}

		domiciliosServicio.eliminar(domicilioAEliminar);
		// datosUsuario.getDomicilios().remove(domicilioAEliminar);

		GenericEntity<List<Domicilio>> list = new GenericEntity<List<Domicilio>>(
				datosUsuario.getDomicilios()) {
		};

		return Response.ok(list).build();
	}

	@Inject
	private DatosUsuario datosUsuario;

	@Inject
	private DomiciliosServicio domiciliosServicio;

}
