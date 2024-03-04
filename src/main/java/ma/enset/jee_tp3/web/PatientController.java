package ma.enset.jee_tp3.web;

import ma.enset.jee_tp3.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientController {

    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping ("/index")
    public String index() {
        return "patients";
    }
}
