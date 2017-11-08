package es.jcyl.educa.javaee.comun.servicio;

import java.util.List;

import javax.ejb.Stateless;
import javax.transaction.Transactional;

import org.hibernate.criterion.Restrictions;

import es.jcyl.educa.javaee.comun.modelo.Municipio;
import es.jcyl.educa.javaee.comun.modelo.MunicipioId;

@Stateless
public class MunicipioServicio extends BaseServicio {

	@Transactional
	public Municipio getMunicipio(Long municipioId, Long provinciaId) {
		return getSession().get(Municipio.class, new MunicipioId(municipioId, provinciaId));
	}

	@Transactional
	public List<Municipio> getMunicipios() {
		return getSession().createCriteria(Municipio.class).list();
	}

	@Transactional
	public List<Municipio> getMunicipios(Long provinciaId) {
		return getSession().createCriteria(Municipio.class)
				.add(Restrictions.eq("municipioId.provincia.id", provinciaId)).list();
	}
}
