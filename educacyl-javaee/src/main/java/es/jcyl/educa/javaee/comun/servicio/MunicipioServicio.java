package es.jcyl.educa.javaee.comun.servicio;

import es.jcyl.educa.javaee.comun.modelo.Municipio;
import es.jcyl.educa.javaee.comun.modelo.MunicipioId;
import org.hibernate.criterion.Restrictions;

import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class MunicipioServicio extends BaseServicio {

	@Transactional
	public Municipio getMunicipio(Integer municipioId, Integer provinciaId) {
		return getSession().get(
			Municipio.class,
			new MunicipioId(municipioId, provinciaId));
	}

	@Transactional
	public List<Municipio> getMunicipios() {

		return getSession().createCriteria(Municipio.class).list();
	}

	@Transactional
	public List<Municipio> getMunicipios(Integer provinciaId) {
		return getSession().createCriteria(Municipio.class)
			.createAlias("provincia", "provincia")
			.add(Restrictions.eq("provincia.id", provinciaId))
			.list();
	}
}
