package es.jcyl.educa.javaee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CURS_CENTROS")
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Centro implements BaseEntity<Long> {

	@Id
	@Column(name = "C_CENTRO_ID")
	private Long centroId;
	@Column(name = "A_DESP")
	private String nombre;
	@Column(name = "N_CURSO_ID")
	private Long cursoId;

	@Override
	public Long getId() {
		return centroId;
	}

	public Long getCentroId() {
		return centroId;
	}

	public void setCentroId(Long centroId) {
		this.centroId = centroId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCursoId() {
		return cursoId;
	}

	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}

}
