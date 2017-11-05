package es.jcyl.educa.javaee.app;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import es.jcyl.educa.javaee.service.CentrosServicio;

/**
 * Created by pestano on 02/05/15.
 */
@Singleton
@Startup
public class InitAppBean {

	@Inject
	CentrosServicio centrosServicio;

	@PostConstruct
	public void init() {

	}
}
