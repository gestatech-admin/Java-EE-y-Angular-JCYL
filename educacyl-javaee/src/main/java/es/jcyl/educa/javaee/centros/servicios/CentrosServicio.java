package es.jcyl.educa.javaee.centros.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import es.jcyl.educa.javaee.centros.api.Filtro;
import es.jcyl.educa.javaee.centros.modelo.Centro;
import es.jcyl.educa.javaee.comun.servicio.BaseServicio;

@Stateless
public class CentrosServicio extends BaseServicio {

	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Centro> getCentros(Filtro filtro) {

		Criteria criteria = getSession().createCriteria(Centro.class).createAlias("estudios",
				"estudios", JoinType.LEFT_OUTER_JOIN);

		if (filtro.getName() != null) {
			criteria.add(Restrictions.eq("nombre", filtro.getName()));
		}

		return criteria.list();
	}

	@Transactional
	public List<Centro> getCentros() {

		return getSession().createCriteria(Centro.class)
				.createAlias("estudios", "estudios", JoinType.LEFT_OUTER_JOIN).list();
	}

	public void crear(Centro centro) {
		getSession().save(centro);
	}

	@Transactional
	public Centro buscarPorId(Long id) {
		Centro centro = getSession().get(Centro.class, id);
		Hibernate.initialize(centro.getEstudios());
		return centro;
	}

	public void eliminar(Centro centro) {
		getSession().delete(centro);
	}

	public Object actualizar(Centro centro) {
		return getSession().merge(centro);
	}

	public Object total() {
		return getSession().createCriteria(Centro.class)
				.setProjection(Projections.count(getSession().getSessionFactory()
						.getClassMetadata(Centro.class).getIdentifierPropertyName()))
				.uniqueResult();
	}

}
