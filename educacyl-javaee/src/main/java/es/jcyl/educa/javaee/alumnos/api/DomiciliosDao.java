package es.jcyl.educa.javaee.alumnos.api;

import java.io.Serializable;

import es.jcyl.educa.javaee.alumnos.modelo.Domicilio;

public interface DomiciliosDao extends Serializable {

	public void eliminar(Domicilio domicilioAEliminar);

}