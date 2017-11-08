package es.jcyl.educa.javaee.comun.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CURS_MUNICIPIOS")
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Municipio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private MunicipioId municipioId;

	@ManyToOne
	@JoinColumn(name = "C_PROV_ID", insertable = false, updatable = false)
	private Provincia provincia;

	@Column(name = "D_MUNI")
	private String nombre;

	public Municipio() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
