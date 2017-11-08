package es.jcyl.educa.javaee.app;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Logged
@Interceptor
public class LoggedInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Logger logger;

	@AroundInvoke
	public Object logMethodEntry(InvocationContext invocationContext) throws Exception {
		logger.info("Entering method: " + invocationContext.getMethod().getName() + " in class "
				+ invocationContext.getMethod().getDeclaringClass().getName());

		return invocationContext.proceed();
	}
}