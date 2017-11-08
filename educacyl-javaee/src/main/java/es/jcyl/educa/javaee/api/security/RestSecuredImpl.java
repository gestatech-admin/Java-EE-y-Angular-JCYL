package es.jcyl.educa.javaee.api.security;

import java.io.Serializable;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;

@RestSecured
@Interceptor
public class RestSecuredImpl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	CustomAuthorizer authorizer;

	@Inject
	Instance<HttpServletRequest> request;

	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		String currentUser = request.get().getHeader("user");
		if (currentUser != null) {
			authorizer.login(currentUser);
		} else {
			throw new Exception("Access forbidden");
		}
		return context.proceed();
	}

}
