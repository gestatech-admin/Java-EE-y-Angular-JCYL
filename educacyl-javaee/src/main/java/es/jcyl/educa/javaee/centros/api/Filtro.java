package es.jcyl.educa.javaee.centros.api;

import java.io.IOException;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Filtro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String date;

	public Filtro() {
		super();
	}

	public static Filtro valueOf(String json) {
		ObjectMapper objectMapper = new ObjectMapper()
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			return objectMapper.readValue(json, Filtro.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
