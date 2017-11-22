package es.jcyl.educa.javaee.alumnos.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import es.jcyl.educa.javaee.comun.modelo.Localidad;

@Entity
@Table(name = "CURS_DOMICILIOS")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Domicilio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "C_PDOMI_ID")
	private Long id;

	@XmlTransient
	@ManyToOne
	@JoinColumn(name = "C_CIE_ID", insertable = false, updatable = false)
	private Alumno alumno;

	@Column(name = "A_NOM_VIA")
	private String nombre;

	@Column(name = "N_NUM_VIA")
	private Integer numero;

	@Column(name = "N_PISO")
	private Integer piso;

	@Column(name = "A_ESCALERA")
	private String escalera;

	@Column(name = "A_LETRA")
	private String letra;

	@Column(name = "C_POSTAL")
	private Integer codigoPostal;

	@Column(name = "A_CORREO_E")
	private String email;

	@Column(name = "N_TELEFONO")
	private Long telefono;

	@ManyToOne
	@JoinColumns(value = { @JoinColumn(name = "C_PROV_ID", referencedColumnName = "C_PROV_ID"),
			@JoinColumn(name = "C_MUNI_ID", referencedColumnName = "C_MUNI_ID"),
			@JoinColumn(name = "C_LOCA_ID", referencedColumnName = "C_LOCA_ID") })
	private Localidad localidad;

	public Domicilio() {
		super();
	}

	public Domicilio(String nombre, Integer numero) {
		super();
		this.nombre = nombre;
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public String getEscalera() {
		return escalera;
	}

	public void setEscalera(String escalera) {
		this.escalera = escalera;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

}
