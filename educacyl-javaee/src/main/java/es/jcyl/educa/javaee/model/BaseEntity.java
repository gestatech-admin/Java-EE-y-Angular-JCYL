package es.jcyl.educa.javaee.model;

import java.io.Serializable;

public interface BaseEntity<T extends Serializable> extends Serializable {

	public T getId();

}
