package es.jcyl.educa.javaee.rest.security;

import java.io.IOException;
import java.security.Key;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import io.jsonwebtoken.Jwts;

@Provider
@Secure
@Priority(Priorities.AUTHENTICATION)
public class SecureFilter implements ContainerRequestFilter {

	@Inject
	private Logger logger;

	@Inject
	private GeneradorClave generadorClave;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			throw new NotAuthorizedException("Authorization header must be provided");
		}

		String token = authorizationHeader.substring("Bearer".length()).trim();

		try {
			Key key = generadorClave.generar();
			String subject = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody()
					.getSubject();
			logger.info("Valid token: " + token + " with subject " + subject);

		} catch (Exception e) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}
	}

}