package hospProj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import hospProj.model.Employee;
import hospProj.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	@Autowired
    private EmployeeService empServ;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		User autherizedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Set<String> roles = AuthorityUtils.authorityListToSet(auth.getAuthorities());
		response.setStatus(HttpServletResponse.SC_OK);
		if(roles.contains("ROLE_DOCTOR")) {
			response.sendRedirect("doctor");
		}
		else if(roles.contains("ROLE_JANITOR")) {
			response.sendRedirect("janitor");
		}
		else if(roles.contains("ROLE_RECEPTIONIST")) {
			response.sendRedirect("receptionist");
		}
		else if(roles.contains("ROLE_NURSE")) {
			response.sendRedirect("nurse");
		}
	}
}
