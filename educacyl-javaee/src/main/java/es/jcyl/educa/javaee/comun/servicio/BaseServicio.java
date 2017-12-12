package es.jcyl.educa.javaee.comun.servicio;

import es.jcyl.educa.javaee.alumnos.modelo.Alumno;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.sql.JoinType;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;

import static org.hibernate.criterion.Restrictions.ilike;

@Dependent
public class BaseServicio {

	@PersistenceContext
	protected EntityManager entityManager;

	protected Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	protected CriteriaBuilder getCB() {
		return entityManager.getCriteriaBuilder();
	}

	private void buscarConSQL() {

		getSession().createSQLQuery(
			"SELECT a.count, b.suma from CURS_ALUMNO a").list();

	}

	private void buscarConCriteriaApi1() {

		Criteria criteria = getSession().createCriteria(Alumno.class);
		criteria.setFetchSize(3);
		criteria.createAlias("centro", "centro", JoinType.INNER_JOIN);
		criteria.createAlias(
			"centro.estudios", "estudios", JoinType.LEFT_OUTER_JOIN);

		if (true) {
			criteria.add(ilike("centro.nombre", "Fernando de Rojas"));
		}
		criteria.list();
	}

	private void buscarConJpql() {

		String cadena =
			"SELECT a.* from Alumno a LEFT OUTER JOIN Centro c " + ""
			+ "WHERE c.id = a.centroId";
		entityManager.createQuery(cadena);
		if (true) {
			cadena += " AND centroId=:nombre";
		}

		Query query = entityManager.createQuery(cadena);

		query.setParameter("nombre", "Fernando de Rojas");
	}

}
