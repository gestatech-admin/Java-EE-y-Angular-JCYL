package es.jcyl.educa.javaee.comun.servicio;

import java.util.List;

import javax.ejb.Stateless;

import es.jcyl.educa.javaee.comun.modelo.Localidad;

@Stateless
public class LocalidadServicio extends BaseServicio {

	public List<Localidad> localidades() {
		return getSession().createCriteria(Localidad.class).list();
	}

}
