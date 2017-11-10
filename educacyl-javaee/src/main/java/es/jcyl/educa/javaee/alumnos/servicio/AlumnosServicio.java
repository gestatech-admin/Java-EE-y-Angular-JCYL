package es.jcyl.educa.javaee.alumnos.servicio;

import java.util.List;

import javax.ejb.Stateless;
import javax.transaction.Transactional;

import org.hibernate.Criteria;

import es.jcyl.educa.javaee.alumnos.modelo.Alumno;
import es.jcyl.educa.javaee.app.Logged;
import es.jcyl.educa.javaee.comun.servicio.BaseServicio;

@Stateless
public class AlumnosServicio extends BaseServicio {

	@Transactional
	@Logged
	public List<Alumno> getAlumnos() {
		List<Alumno> resultList = entityManager.createQuery("SELECT a FROM Alumno a")
				.getResultList();

		for (Alumno alumno : resultList) {
			alumno.getEstudios().isEmpty();
		}

		return resultList;
	}

	@Transactional
	public List<Alumno> getAlumnosDeUnCentro(Long centroId) {
		List<Alumno> resultList = entityManager.createQuery(
				"SELECT distinct a FROM Alumno a JOIN FETCH a.estudios ae WHERE a.id = ae.alumno AND ae.centro.id = :centroId")
				.setParameter("centroId", centroId).getResultList();

		return resultList;
	}

	public List<Alumno> getAlumnos(Integer page) {

		Criteria criteria = getSession().createCriteria(Alumno.class);
		criteria.setFirstResult((page - 1) * 10);
		criteria.setMaxResults(10);
		List<Alumno> list = criteria.list();
		for (Alumno alumno : list) {
			alumno.getEstudios().isEmpty();
		}
		return list;
	}

}
