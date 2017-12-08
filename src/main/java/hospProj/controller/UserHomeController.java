package hospProj.controller;

import hospProj.model.Employee;
import hospProj.service.EmployeeService;
import hospProj.utils.EncryptedPasswordUtils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.context.SecurityContextHolder;


@Controller
@RequestMapping("/home")
public class UserHomeController {
	@GetMapping
	public String getProperPage(@ModelAttribute("employee") Employee emp, Model model)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Set<String> roles = AuthorityUtils.authorityListToSet(auth.getAuthorities());
		if(roles.contains("ROLE_DOCTOR"))return "doctorHome";
		if(roles.contains("ROLE_NURSE"))return "nurseHome";
		if(roles.contains("ROLE_RECEPTIONIST"))return "receptionistHome";
		if(roles.contains("ROLE_JANITOR"))return "janitorHome";
		return "index";
	}
}
