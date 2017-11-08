package es.jcyl.educa.javaee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class MunicipioId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "C_PROV_ID")
	@Transient
	private Long provinciaId;

	@Column(name = "C_MUNI_ID")
	private Long municipioId;

	public MunicipioId() {
		super();
	}

	public MunicipioId(Long municipioId, Long provinciaId) {
		this.municipioId = municipioId;
		this.provinciaId = provinciaId;
	}

	public Long getMunicipioId() {
		return municipioId;
	}

	public void setMunicipioId(Long municipioId) {
		this.municipioId = municipioId;
	}

}
