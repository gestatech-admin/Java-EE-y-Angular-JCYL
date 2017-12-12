package es.jcyl.educa.javaee.comun.servicio;

import es.jcyl.educa.javaee.comun.modelo.Provincia;
import es.jcyl.educa.javaee.comun.modelo.Provincia_;
import org.hibernate.criterion.Projections;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class ProvinciasServicio extends BaseServicio {

	@Transactional
	public List<Provincia> getProvincias() {

		CriteriaBuilder builder = getCB();

		CriteriaQuery<Provincia> query = builder.createQuery(Provincia.class);
		Root<Provincia> variableRoot = query.from(Provincia.class);
		CriteriaQuery<Provincia> select = query.where(
			builder.notEqual(
				variableRoot.get(Provincia_.id),
				builder.parameter(Integer.class, "id")
			));

		return entityManager
			.createQuery(select)
			.setParameter("id", 9)
			.getResultList();
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

	public Provincia actualizar(Provincia provincia) {
		return entityManager.merge(provincia);
	}

	public Integer total() {
		return (Integer)getSession().createCriteria(Provincia.class)
			.setProjection(Projections.count(getSession().getSessionFactory()
				.getClassMetadata(Provincia.class).getIdentifierPropertyName()))
			.uniqueResult();
	}

}
