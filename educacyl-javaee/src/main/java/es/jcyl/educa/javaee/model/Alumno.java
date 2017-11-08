package es.jcyl.educa.javaee.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "CURS_ALUMNOS")
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "C_CIE_ID")
	private String id;

	@Column(name = "C_NUMIDE")
	private String numero;

	@Column(name = "A_NOMBRE")
	private String nombre;

	@Column(name = "A_APELLIDO1")
	private String apellido1;

	@Column(name = "A_APELLIDO2")
	private String apellido2;

	@Column(name = "B_SEXO")
	private String sexo;

	@Column(name = "F_NACIMIENTO")
	private String fechaNacimiento;

	@OneToMany
	@JoinColumn(name = "C_CIE_ID")
	@BatchSize(size = 20)
	private Set<AlumnoEstudios> estudios = new HashSet<>();

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "C_CIE_ID")
	@Fetch(FetchMode.SUBSELECT)
	private Set<Domicilio> domicilios = new HashSet<>();

	public Alumno() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Set<AlumnoEstudios> getEstudios() {
		return estudios;
	}

	public Set<Domicilio> getDomicilios() {
		return domicilios;
	}

	public void setDomicilios(Set<Domicilio> domicilios) {
		this.domicilios = domicilios;
	}

	public void setEstudios(Set<AlumnoEstudios> estudios) {
		this.estudios = estudios;
	}

}
