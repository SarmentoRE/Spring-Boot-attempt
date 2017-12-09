//package hospProj.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import hospProj.model.PatientOccupy;
//import hospProj.service.PatientOccupyService;
//
//@Controller
//@RequestMapping("/room/change")
//public class RoomChangeController {
//	
//	@Autowired
//	private PatientOccupyService patientOccupyService;
//	
//	@ModelAttribute("patientOccupy")
//	public PatientOccupy getPatientOccupy() {
//		return new PatientOccupy();
//	}
//	
//	@GetMapping
//	public String roomChangeForm(Model model) {
//		return"room/change";
//	}
//	
//	@PostMapping
//	public String changePatientRoom(@ModelAttribute("patientOccupy")PatientOccupy pat, BindingResult result) {
//		patientOccupyService.saveOrUpdate(pat);
//		return"redirect:/room";
//	}
//}