package es.jcyl.educa.javaee.comun.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import es.jcyl.educa.javaee.centros.modelo.Centro;

@Entity
public class Personal implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Length(min = 4, max = 10)
	@Email
	@Column(nullable = false)
	private String nombre;
	private String apellido1;
	private String apellido2;

	// @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "C_CENTRO_ID")
	private Centro centro;

	@Transient
	private Long edad;

	public Personal() {
		super();
	}

	public Personal(String nombre, String apellido1, String apellido2, Long edad) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Long getEdad() {
		return edad;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}

	// public Centro getCentro() {
	// return centro;
	// }
	//
	// public void setCentro(Centro centro) {
	// this.centro = centro;
	// }

}
