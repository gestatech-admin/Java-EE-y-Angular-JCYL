package es.jcyl.educa.javaee.alumnos.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;

import es.jcyl.educa.javaee.alumnos.modelo.Domicilio;

@SessionScoped
public class DatosUsuario implements Serializable {

	private boolean logueado;

	private List<Domicilio> domicilios = new ArrayList<Domicilio>() {
		{
			add(new Domicilio("Rigoberto", 4));
			add(new Domicilio("Paseo Zorrilla", 10));
		}
	};

	public List<Domicilio> getDomicilios() {
		return domicilios;
	}

	public void setDomicilios(List<Domicilio> domicilios) {
		this.domicilios = domicilios;
	}

	public boolean esLogueado() {
		return logueado;
	}

	public void setLogueado(boolean logueado) {
		this.logueado = logueado;
	}

}
