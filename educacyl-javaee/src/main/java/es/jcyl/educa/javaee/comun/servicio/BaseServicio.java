package es.jcyl.educa.javaee.comun.servicio;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

@Dependent
public class BaseServicio {

	@PersistenceContext
	protected EntityManager entityManager;

	protected Session getSession() {
		return (Session) entityManager.getDelegate();
	}

}
