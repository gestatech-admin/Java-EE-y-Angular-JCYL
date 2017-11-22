package es.jcyl.educa.javaee.usuarios.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import es.jcyl.educa.javaee.alumnos.modelo.Domicilio;

@Entity
@Table
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuario {

	@Id
	@GeneratedValue
	private String id;
	private String nombre;
	private String apellidos;
	private String login;
	private String password;

	public Usuario() {
	}

	public Usuario(String nombre, String apellidos, String login, String password) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.login = login;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Domicilio> getDomicilios() {
		return null;
	}

}
