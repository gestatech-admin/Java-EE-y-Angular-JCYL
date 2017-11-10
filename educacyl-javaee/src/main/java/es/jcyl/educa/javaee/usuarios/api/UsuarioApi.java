package es.jcyl.educa.javaee.usuarios.api;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import java.security.Key;
import java.security.MessageDigest;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import es.jcyl.educa.javaee.api.security.GeneradorClave;
import es.jcyl.educa.javaee.usuarios.modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Path("/usuarios")
@Transactional
public class UsuarioApi {

	@Context
	private UriInfo uriInfo;

	@Inject
	private Logger logger;

	@Inject
	private GeneradorClave generadorClave;

	@PersistenceContext
	private EntityManager em;

	@POST
	@Path("/login")
	@Consumes(APPLICATION_FORM_URLENCODED)
	public Response login(@FormParam("login") String login,
			@FormParam("password") String password) {
		try {
			authenticate(login, password);
			String token = crearToken(login);
			return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();
		} catch (Exception e) {
			return Response.status(UNAUTHORIZED).build();
		}
	}

	@GET
	public Response usuarios() {
		List<Usuario> usuarios = em.unwrap(Session.class).createCriteria(Usuario.class).list();
		return Response.ok(usuarios).build();
	}

	private void authenticate(String login, String password) throws Exception {

		Usuario usuario = (Usuario) em.unwrap(Session.class).createCriteria(Usuario.class)
				.add(Restrictions.eq("password", digest(password)))
				.add(Restrictions.eq("login", login)).uniqueResult();
		if (usuario == null) {
			throw new SecurityException("Invalid user/password");
		}
	}

	private String crearToken(String login) {
		Key clave = generadorClave.generar();
		String token = Jwts.builder().setSubject(login).setIssuedAt(new Date())
				.setExpiration(Date.from(Instant.now().plus(Duration.ofMinutes(10))))
				.setIssuer(uriInfo.getAbsolutePath().toString())
				.signWith(SignatureAlgorithm.HS512, clave).compact();
		logger.info("Token generado! " + token);
		return token;
	}

	private static String digest(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes("UTF-8"));
			byte[] passwordDigest = md.digest();
			return new String(Base64.getEncoder().encode(passwordDigest));
		} catch (Exception e) {
			throw new RuntimeException("Exception encoding password", e);
		}
	}

}
