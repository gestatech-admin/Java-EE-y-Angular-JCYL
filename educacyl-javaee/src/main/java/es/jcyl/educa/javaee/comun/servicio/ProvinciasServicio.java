package es.jcyl.educa.javaee.comun.servicio;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.criterion.Projections;

import es.jcyl.educa.javaee.comun.modelo.Provincia;

@Stateless
public class ProvinciasServicio extends BaseServicio {

	@Transactional
	public List<Provincia> getProvincias() {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Provincia> query = builder.createQuery(Provincia.class);
		Root<Provincia> variableRoot = query.from(Provincia.class);
		CriteriaQuery<Provincia> select = query.where(
				builder.notEqual(variableRoot.get("id"), builder.parameter(Long.class, "id")));

		return entityManager.createQuery(select).setParameter("id", 47L).getResultList();
	}

	public void crear(Provincia provincia) {
		entityManager.persist(provincia);
	}

	public Provincia buscarPorId(Integer id) {
		return entityManager.find(Provincia.class, id);
	}

	public void eliminar(Provincia provincia) {
		entityManager.remove(provincia);
	}

	public Object actualizar(Provincia provincia) {
		return entityManager.merge(provincia);
	}

	public Object total() {
		return getSession().createCriteria(Provincia.class)
				.setProjection(Projections.count(getSession().getSessionFactory()
						.getClassMetadata(Provincia.class).getIdentifierPropertyName()))
				.uniqueResult();
	}

}
