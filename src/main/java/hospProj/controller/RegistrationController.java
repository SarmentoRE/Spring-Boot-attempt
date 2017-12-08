package hospProj.controller;

import hospProj.model.Employee;
import hospProj.service.EmployeeService;
import hospProj.utils.EncryptedPasswordUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private EmployeeService empServ;

    @ModelAttribute("employee")
    public Employee getEmployee()
    {
    	return new Employee();
    }
    
    @GetMapping
    public String showRegistrationForm(Model model) {
        return "newEmployee";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("employee") Employee emp, 
                                      BindingResult result){

        Employee existing = empServ.searchByUsername(emp.getUsername());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that username");
        }

        if (result.hasErrors()){
            return "newEmployee";
        }
        emp.setPassword(EncryptedPasswordUtils.encryptPassword(emp.getPassword()));
        empServ.saveOrUpdate(emp);
        return "redirect:/home";
    }

}