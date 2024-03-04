package ma.enset.jee_tp3.repository;

import ma.enset.jee_tp3.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
