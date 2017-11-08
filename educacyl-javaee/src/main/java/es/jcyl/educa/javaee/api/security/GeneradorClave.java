package es.jcyl.educa.javaee.api.security;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

public class GeneradorClave {

	public Key generar() {
		String clave = "password";
		return new SecretKeySpec(clave.getBytes(), 0, clave.getBytes().length, "DES");
	}

}
