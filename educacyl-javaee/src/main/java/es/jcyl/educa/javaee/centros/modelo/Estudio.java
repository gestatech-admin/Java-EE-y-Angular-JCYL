package es.jcyl.educa.javaee.centros.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "CURS_ESTUDIOS")
@Entity
public class Estudio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "N_CURSO_ID")
	private Integer cursoId;

	@ManyToOne
	@JoinColumn(name = "C_CENTRO_ID")
	private Centro centro;

	@Column(name = "C_ESTUDIO_ID")
	private Integer estudioId;

	@Column(name = "D_ESTUDIO_ABREV")
	private String abrev;

	@Column(name = "D_ESTUDIO")
	private String descripcion;
}
