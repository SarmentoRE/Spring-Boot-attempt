package hospProj.controller;

import hospProj.model.Patient;
import hospProj.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/newPatient")
public class PatientController {

    @Autowired
    private PatientService patServ;

    @ModelAttribute("patient")
    public Patient getPatient()
    {
    	return new Patient();
    }
    
    @GetMapping
    public String showRegistrationForm(Model movdel) {
        return "newPatient";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("patient") Patient patient, 
                                      BindingResult result){

        Patient existing = patServ.searchById(patient.getPatientId());

        if (result.hasErrors()){
            return "newPatient";
        }
        patServ.saveOrUpdate(patient);
        return "redirect:/patient/list";
    }

}