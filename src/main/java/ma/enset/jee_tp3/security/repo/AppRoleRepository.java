package ma.enset.jee_tp3.security.repo;

import ma.enset.jee_tp3.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {
}
