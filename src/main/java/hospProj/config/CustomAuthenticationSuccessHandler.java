package hospProj.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		Set<String> roles = AuthorityUtils.authorityListToSet(auth.getAuthorities());
		response.setStatus(HttpServletResponse.SC_OK);
		if(roles.contains("ROLE_DOCTOR")) {
			response.sendRedirect("doctor");
		}
		else if(roles.contains("ROLE_JANITOR")) {
			response.sendRedirect("janitor");
		}
		else if(roles.contains("ROLE_RECEPTIONIST")) {
			response.sendRedirect("RECEPTIONIST");
		}
		else if(roles.contains("ROLE_NURSE")) {
			response.sendRedirect("NURSE");
		}
	}
}
