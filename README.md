# Activité Pratique N°3 : Spring MVC Spring Data JPA Thymeleaf
## Entity Patient
```java
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "patients")
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private int score;
    private boolean malade;
}
```
## PatientReop
```java
public interface PatientRepository extends JpaRepository<Patient, Long> {
        public Page<Patient> findByNomContains(String nom, PageRequest pageRequest);
}
```
## Controller
```java
 @Controller
    public class PatientController {

        private PatientRepository patientRepository;

        public PatientController(PatientRepository patientRepository) {
            this.patientRepository = patientRepository;
        }

        @GetMapping ("/index")
        public String index(Model model,@RequestParam(name = "page", defaultValue = "0") int page,
                            @RequestParam(name = "size", defaultValue = "5") int size,
                            @RequestParam(name = "keyword", defaultValue = "") String keyword) {
            Page<Patient> patients  = patientRepository.findByNomContains(keyword, PageRequest.of(page, size));
            model.addAttribute("listPatients", patients.getContent());
            model.addAttribute("pages", new int[patients.getTotalPages()]);
            model.addAttribute("currentPage", page);
            model.addAttribute("keyword", keyword);
            return "patients";
        }

        @GetMapping("/")
        public String home() {
            return "redirect:/index";
        }

        @GetMapping ("/deletePatient")
        public String delete(@RequestParam(name ="id") Long id) {
            patientRepository.deleteById(id);
            return "redirect:/index";
        }
    }
```
