package es.jcyl.educa.javaee.comun.modelo;

import java.io.Serializable;

public interface AbstractEntidad<T extends Serializable> extends Serializable {

	public T getId();

}
