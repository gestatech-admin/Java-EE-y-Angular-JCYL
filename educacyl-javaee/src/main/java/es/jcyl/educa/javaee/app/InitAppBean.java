package es.jcyl.educa.javaee.app;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import es.jcyl.educa.javaee.service.CentrosServicio;

@Singleton
@Startup
public class InitAppBean {

	@Inject
	CentrosServicio centrosServicio;

	@PostConstruct
	public void init() {

	}
}
