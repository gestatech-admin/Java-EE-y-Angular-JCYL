package es.jcyl.educa.javaee.alumnos.api;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import es.jcyl.educa.javaee.alumnos.modelo.Domicilio;

@RequestScoped
public class DomiciliosServicio implements Serializable {

	@Inject
	private DomiciliosDao domiciliosDao;

	@Inject
	private AlumnosDao alumnosDao;

	public void eliminar(Domicilio domicilioAEliminar) {
		domiciliosDao.eliminar(domicilioAEliminar);
		alumnosDao.eliminar(domicilioAEliminar);
	}

}
