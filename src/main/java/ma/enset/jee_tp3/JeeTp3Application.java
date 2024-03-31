package ma.enset.jee_tp3;

import ma.enset.jee_tp3.entities.Patient;
import ma.enset.jee_tp3.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
            Patient p7 = new Patient(null,"Younes", "bouzidi", new Date(), 32, false);
            Patient p8 = new Patient(null,"Younes", "bouzidi", new Date(), 32, false);
            Patient p9 = new Patient(null, "Younes", "bouzidi", new Date(), 32, false);
            Patient p10 = new Patient(null, "Imane", "Lahcen", new Date(), 30, false);
            Patient p11 = new Patient(null, "Driss", "Bensaid", new Date(), 46, true);
            Patient p12 = new Patient(null, "Leila", "Maarouf", new Date(), 42, false);
            Patient p13 = new Patient(null, "Omar", "Bennani", new Date(), 26, true);
            Patient p14 = new Patient(null, "Fatima", "El Youssfi", new Date(), 21, false);
            Patient p15 = new Patient(null, "Hassan", "Alaoui", new Date(), 35, true);
            Patient p16 = new Patient(null, "Aicha", "Belkacem", new Date(), 32, false);
            Patient p17 = new Patient(null, "Karim", "Dahmani", new Date(), 49, true);
            Patient p18 = new Patient(null, "Sara", "Guessous", new Date(), 23, false);
            // insert 10 more



            patientRepository.save(p1);
            patientRepository.save(p2);
            patientRepository.save(p3);
            patientRepository.save(p4);
            patientRepository.save(p5);
            patientRepository.save(p6);
            patientRepository.save(p7);
            patientRepository.save(p8);
            patientRepository.save(p9);
            patientRepository.save(p10);
            patientRepository.save(p11);
            patientRepository.save(p12);
            patientRepository.save(p13);
            patientRepository.save(p14);
            patientRepository.save(p15);
            patientRepository.save(p16);
            patientRepository.save(p17);
            patientRepository.save(p18);

            patientRepository.findAll().forEach(System.out::println);


        };
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
