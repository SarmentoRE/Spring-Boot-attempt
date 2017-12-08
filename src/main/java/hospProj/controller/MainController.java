package hospProj.controller;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hospProj.model.Employee;
import hospProj.service.PatientService;

@Controller
public class MainController {
	private PatientService patientService;
	
	@Autowired
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@RequestMapping({"/","/home"})
	public String homePage(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
	    model.addAttribute("title", "Logout");
	    return "logoutSuccessfulPage";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "index";
    }
	
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {
		String userName = principal.getName();
		System.out.println("User Name: " + userName);
		return "userInfoPage";
	}
	
	@RequestMapping(value = "/janitor", method = RequestMethod.GET)
	public String janitorPage(Model model) {
		return "janitor";
	}
	
	@RequestMapping(value = "/doctor", method = RequestMethod.GET)
	public String doctorPage(Model model) {
		return "doctor";
	}
	
	@RequestMapping(value = "/nurse", method = RequestMethod.GET)
	public String nursePage(Model model) {
		return "nurse";
	}
	
	@RequestMapping(value = "/receptionist", method = RequestMethod.GET)
	public String receptionistPage(Model model) {
		return "receptionist";
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
            String userInfo = loginedUser.getUsername();
            model.addAttribute("userInfo", userInfo);
 
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
 
        }
 
        return "403Page";
    }
	
	@RequestMapping("/info")
	public String getInfoPage( Model model)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Set<String> roles = AuthorityUtils.authorityListToSet(auth.getAuthorities());
		if(roles.contains("ROLE_DOCTOR"))return "doctorInfo";
		if(roles.contains("ROLE_NURSE"))return "nurseInfo";
		if(roles.contains("ROLE_RECEPTIONIST"))return "empInfo";
		if(roles.contains("ROLE_JANITOR"))return "empInfo";
		return "index";
	}
	
	 @RequestMapping({"/patient/list", "/patients"})
	    public String listPatients(Model model){
	        model.addAttribute("patients", patientService.listAll());
	        return "patient/list";
	}
	 
	 @RequestMapping({"/patient/show/{id}"})
	 	public String getPatient(@PathVariable String id, Model model) {
		model.addAttribute("patient",patientService.searchById(Integer.valueOf(id)));
		return "patient/show";
	 }
}
