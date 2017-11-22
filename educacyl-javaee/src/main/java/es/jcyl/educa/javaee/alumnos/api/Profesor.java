package es.jcyl.educa.javaee.alumnos.api;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profesor implements Serializable {

	@Id
	private String dni;

	private String nombre;
	private String especialidad;

}
