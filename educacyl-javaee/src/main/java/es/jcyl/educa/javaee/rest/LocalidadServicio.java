package es.jcyl.educa.javaee.rest;

import java.util.List;

import javax.ejb.Stateless;

import es.jcyl.educa.javaee.model.Localidad;
import es.jcyl.educa.javaee.service.BaseServicio;

@Stateless
public class LocalidadServicio extends BaseServicio {

	public List<Localidad> localidades() {
		return getSession().createCriteria(Localidad.class).list();
	}

}
