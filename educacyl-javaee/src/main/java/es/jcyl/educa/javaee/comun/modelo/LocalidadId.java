package es.jcyl.educa.javaee.comun.modelo;

import java.io.Serializable;

public class LocalidadId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer provinciaId;

	private Integer municipioId;

	private Integer localidadId;

	public Integer getProvinciaId() {
		return provinciaId;
	}

	public void setProvinciaId(Integer provinciaId) {
		this.provinciaId = provinciaId;
	}

	public Integer getMunicipioId() {
		return municipioId;
	}

	public void setMunicipioId(Integer municipioId) {
		this.municipioId = municipioId;
	}

	public Integer getLocalidadId() {
		return localidadId;
	}

	public void setLocalidadId(Integer localidadId) {
		this.localidadId = localidadId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (localidadId == null ? 0 : localidadId.hashCode());
		result = prime * result + (municipioId == null ? 0 : municipioId.hashCode());
		result = prime * result + (provinciaId == null ? 0 : provinciaId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		LocalidadId other = (LocalidadId) obj;
		if (localidadId == null) {
			if (other.localidadId != null) {
				return false;
			}
		} else if (!localidadId.equals(other.localidadId)) {
			return false;
		}
		if (municipioId == null) {
			if (other.municipioId != null) {
				return false;
			}
		} else if (!municipioId.equals(other.municipioId)) {
			return false;
		}
		if (provinciaId == null) {
			if (other.provinciaId != null) {
				return false;
			}
		} else if (!provinciaId.equals(other.provinciaId)) {
			return false;
		}
		return true;
	}

}
