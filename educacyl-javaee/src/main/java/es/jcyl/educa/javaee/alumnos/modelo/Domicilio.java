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

}
