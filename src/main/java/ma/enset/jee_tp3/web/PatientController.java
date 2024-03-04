package ma.enset.jee_tp3.web;

import ma.enset.jee_tp3.entities.Patient;
import ma.enset.jee_tp3.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {

    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping ("/index")
    public String index(Model model,@RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "5") int size) {
        Page<Patient> patients  = patientRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("listPatients", patients.getContent());
        model.addAttribute("pages", new int[patients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        return "patients";
    }

    @GetMapping ("/deletePatient")
    public String delete(@RequestParam(name ="id") Long id) {
        patientRepository.deleteById(id);
        return "redirect:/index";
    }
}
