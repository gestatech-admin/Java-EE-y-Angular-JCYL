package es.jcyl.educa.javaee.centros.servicios;

import es.jcyl.educa.javaee.alumnos.api.DatosUsuario;
import es.jcyl.educa.javaee.centros.api.Filtro;
import es.jcyl.educa.javaee.centros.modelo.Centro;
import es.jcyl.educa.javaee.centros.modelo.Centro_;
import es.jcyl.educa.javaee.comun.servicio.BaseServicio;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
public class CentrosServicio extends BaseServicio {

	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Centro> getCentros(@QueryParam("filtro") Filtro filtro) {

		Criteria criteria =
			getSession().createCriteria(Centro.class).createAlias("estudios",
				"estudios", JoinType.LEFT_OUTER_JOIN);

		if (filtro.getName() != null) {
			criteria.add(Restrictions.eq("nombre", filtro.getName()));
		}

		return criteria.list();
	}

	@Transactional
	public List<Centro> getCentros() {
		return getSession().createCriteria(Centro.class)
			.createAlias("estudios", "estudios", JoinType.LEFT_OUTER_JOIN)
			.list();
	}

	public List<Centro> getCentros(
		Integer provinciaId, Integer municipioId, Integer localidadId) {

		CriteriaBuilder builder = getCB();

		CriteriaQuery<Centro> query = builder.createQuery(Centro.class);
		Root<Centro> centroRoot = query.from(Centro.class);
		CriteriaQuery<Centro> select = query.where(
			builder.like(
				centroRoot.get(Centro_.centroId).as(String.class),
				provinciaId + "%")
		);
		return entityManager.createQuery(select).getResultList();
	}

	public List<Centro> getCentros(int page) {
		Criteria criteria = getSession().createCriteria(Centro.class);
		int maxResults = 10;
		criteria.setMaxResults(maxResults);
		criteria.setFirstResult(page * maxResults);
		return criteria.list();
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

	@Inject
	private DatosUsuario datosUsuario;

}
