package es.jcyl.educa.javaee.comun.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@IdClass(LocalidadId.class)
@Entity
@Table(name = "CURS_LOCALIDADES")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Localidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "C_PROV_ID")
	private Long provinciaId;

	@Id
	@Column(name = "C_MUNI_ID")
	private Long municipioId;

	@Id
	@Column(name = "C_LOCA_ID")
	private Long localidadId;

	@Column(name = "D_LOCA")
	private String descripcion;

	@Column(name = "C_POSTAL")
	private Integer codigoPostal;

}
