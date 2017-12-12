package es.jcyl.educa.javaee.comun.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MunicipioId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "C_PROV_ID")
	private Integer provinciaId;

	@Column(name = "C_MUNI_ID")
	private Integer municipioId;

	public MunicipioId() {
		super();
	}

	public MunicipioId(Integer municipioId, Integer provinciaId) {
		this.municipioId = municipioId;
		this.provinciaId = provinciaId;
	}

	public Integer getMunicipioId() {
		return municipioId;
	}

	public void setMunicipioId(Integer municipioId) {
		this.municipioId = municipioId;
	}

}
