package es.jcyl.educa.javaee.security;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Named;
import javax.interceptor.InvocationContext;

import org.apache.deltaspike.security.api.authorization.Secures;

@SessionScoped
@Named("authorizer")
public class CustomAuthorizer implements Serializable {

	private Map<String, String> currentUser = new ConcurrentHashMap<>();

	@Secures
	@Admin
	public boolean doAdminCheck(InvocationContext invocationContext, BeanManager manager)
			throws Exception {
		boolean allowed = currentUser.containsKey("user")
				&& currentUser.get("user").equals("admin");
		if (!allowed) {
			throw new Exception("Access denied");
		}
		return allowed;
	}

	@Secures
	@Guest
	public boolean doGuestCheck(InvocationContext invocationContext, BeanManager manager)
			throws Exception {
		boolean allowed = currentUser.containsKey("user") && currentUser.get("user").equals("guest")
				|| doAdminCheck(null, null);
		if (!allowed) {
			throw new Exception("Access denied");
		}
		return allowed;
	}

	public void login(String username) {
		currentUser.put("user", username);
	}

	public Map<String, String> getCurrentUser() {
		return currentUser;
	}
}
