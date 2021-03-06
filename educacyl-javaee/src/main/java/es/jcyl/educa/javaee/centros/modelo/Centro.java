package es.jcyl.educa.javaee.centros.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;

import es.jcyl.educa.javaee.alumnos.modelo.AlumnoEstudios;
import es.jcyl.educa.javaee.comun.modelo.AbstractEntidad;
import es.jcyl.educa.javaee.comun.modelo.Personal;

@Entity
@Table(name = "CURS_CENTROS")
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Centro implements AbstractEntidad<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "C_CENTRO_ID")
	private Long centroId;
	@Length(max = 10, min = 10)
	@Column(name = "A_DESP")
	private String nombre;
	@Column(name = "N_CURSO_ID")
	private Long cursoId;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "C_CENTRO_ID")
	@Fetch(FetchMode.SUBSELECT)
	private Set<AlumnoEstudios> estudios = new HashSet<>();

	@OneToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinColumn(name = "C_CENTRO_ID", referencedColumnName = "C_CENTRO_ID")
	private List<Personal> empleados = new ArrayList<>();

	public List<Personal> getListaPersonal() {
		return new ArrayList<>(empleados);
	}

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

	public Set<AlumnoEstudios> getEstudios() {
		return estudios;
	}

	public void setEstudios(Set<AlumnoEstudios> estudios) {
		this.estudios = estudios;
	}

}
