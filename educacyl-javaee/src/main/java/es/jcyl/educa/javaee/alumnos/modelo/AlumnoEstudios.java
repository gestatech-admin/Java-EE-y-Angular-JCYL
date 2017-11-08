package es.jcyl.educa.javaee.alumnos.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import es.jcyl.educa.javaee.centros.modelo.Centro;

@Entity
@Table(name = "CURS_ALUM_ESTUDIOS")
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class AlumnoEstudios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "C_CIE_ID")
	@XmlTransient
	private Alumno alumno;

	@Column(name = "N_CURSO_ID")
	private Integer numero;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "C_CENTRO_ID")
	@XmlTransient
	private Centro centro;

	@Column(name = "C_ESTUDIO_ID")
	private String estudioId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

	public String getEstudioId() {
		return estudioId;
	}

	public void setEstudioId(String estudioId) {
		this.estudioId = estudioId;
	}

}
