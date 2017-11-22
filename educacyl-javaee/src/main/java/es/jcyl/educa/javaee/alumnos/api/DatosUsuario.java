package es.jcyl.educa.javaee.alumnos.api;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;

import es.jcyl.educa.javaee.usuarios.modelo.Usuario;

@SessionScoped
public class DatosUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
