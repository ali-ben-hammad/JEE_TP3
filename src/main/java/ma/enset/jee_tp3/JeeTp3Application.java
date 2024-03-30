package ma.enset.jee_tp3;

import ma.enset.jee_tp3.entities.Patient;
import ma.enset.jee_tp3.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class JeeTp3Application {

    public static void main(String[] args) {
        SpringApplication.run(JeeTp3Application.class, args);
    }
   @Bean
    public CommandLineRunner start(PatientRepository patientRepository) {
        return args -> {
            Patient p1 = new Patient();
            p1.setNom("Ali");
            p1.setPrenom("Ben");
            p1.setDateNaissance(new Date());
            p1.setScore(18);
            p1.setMalade(false);

            Patient p2 = new Patient(null,"hamza", "baqqal", new Date(), 19, true);
            Patient p3 = new Patient(null,"Achraf", "hammi", new Date(), 12, true);
            Patient p4 = new Patient(null,"Oussama", "berhili", new Date(), 21, true);
            Patient p5 = new Patient(null,"Yacer", "benali", new Date(), 52, false);
            Patient p6 = new Patient(null,"Aymane", "barri", new Date(), 97, true);

            patientRepository.save(p1);
            patientRepository.save(p2);
            patientRepository.save(p3);
            patientRepository.save(p4);
            patientRepository.save(p5);
            patientRepository.save(p6);

            patientRepository.findAll().forEach(System.out::println);


        };
    }

}
