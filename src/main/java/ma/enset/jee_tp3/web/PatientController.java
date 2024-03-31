package ma.enset.jee_tp3.web;

import jakarta.validation.Valid;
import ma.enset.jee_tp3.entities.Patient;
import ma.enset.jee_tp3.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {

    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/user/index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "5") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Patient> patients = patientRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("listPatients", patients.getContent());
        model.addAttribute("pages", new int[patients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "patients";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/user/index";
    }

    @GetMapping("/admin/formPatient")
    public String formPatient(Model model,
                              @RequestParam(name = "keyword", defaultValue = "") String keyword,
                              @RequestParam(name = "page", defaultValue = "0") int page) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("mode", "new");
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        return "formPatient";
    }

    @PostMapping("/admin/savePatient")
    public String savePatient(Model model, @Valid Patient patient, BindingResult bindingResult,
                              @RequestParam(name = "id", defaultValue = "") Long id,
                              @RequestParam(name = "keyword", defaultValue = "") String keyword,
                              @RequestParam(name = "page", defaultValue = "0") int page) {
        if (bindingResult.hasErrors()) return "formPatient";
        if (id != null) patient.setId(id);

        patientRepository.save(patient);

        model.addAttribute("patient", patient);
        return "redirect:/user/index?keyword=" + keyword + "&page=" + page;
    }

    @GetMapping("/admin/deletePatient")
    public String delete(Long id,
                         @RequestParam(name = "keyword", defaultValue = "") String keyword,
                         @RequestParam(name = "page", defaultValue = "0 ") int page
    ) {
        patientRepository.deleteById(id);
        return "redirect:/user/index" + "?keyword=" + keyword + "&page=" + page
                ;
    }

    @GetMapping("/admin/editPatient")
    public String edit(Model model, Long id,
                       @RequestParam(name = "keyword", defaultValue = "") String keyword,
                       @RequestParam(name = "page", defaultValue = "0") int page) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient == null) throw new RuntimeException("Patient not found");
        model.addAttribute("patient", patient);
        model.addAttribute("mode", "edit");
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        return "formPatient";
    }

}
