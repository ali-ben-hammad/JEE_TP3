package ma.enset.jee_tp3.security.Service;

import ma.enset.jee_tp3.security.entities.AppRole;
import ma.enset.jee_tp3.security.entities.AppUser;

public interface AccountService {
    AppUser addNewUser(String username, String password, String email, String confirmedPassword);
    AppRole addNewRole(String role);
    void addRoleToUser(String username, String role);
    void removeRoleToUser(String username, String role);
    AppUser loadUserByUsername(String username);
}
