package es.jcyl.educa.javaee.comun.servicio;

import es.jcyl.educa.javaee.comun.modelo.Localidad;
import org.hibernate.Criteria;

import javax.ejb.Stateless;
import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;

@Stateless
public class LocalidadServicio extends BaseServicio {

	public List<Localidad> localidades() {
		return criteria().list();
	}

	public List<Localidad> localidades(
		Integer provinciaId, Integer municipioId) {
		return criteria()
			.add(eq("provinciaId", provinciaId))
			.add(eq("municipioId", municipioId))
			.list();
	}

	private Criteria criteria() {
		return getSession().createCriteria(Localidad.class);
	}
}
