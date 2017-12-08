package hospProj.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hospProj.model.Employee;

@Controller
public class MainController {
	
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
	
	@RequestMapping(value = "/janitorPage", method = RequestMethod.GET)
	public String janitorPage(Model model) {
		return "janitorPage";
	}
	
	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public String newEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "newEmployee";
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
}
