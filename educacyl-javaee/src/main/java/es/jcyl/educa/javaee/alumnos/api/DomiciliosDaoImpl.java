package es.jcyl.educa.javaee.alumnos.api;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.jcyl.educa.javaee.alumnos.modelo.Domicilio;

@Stateless
public class DomiciliosDaoImpl implements DomiciliosDao {

	@PersistenceContext
	protected EntityManager entityManager;

	public void eliminar(Domicilio domicilioAEliminar) {
		entityManager.remove(domicilioAEliminar);
	}

}
