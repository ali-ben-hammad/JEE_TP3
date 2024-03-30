package ma.enset.jee_tp3.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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
    @NotEmpty
    @Size(min = 3, max = 15)
    private String nom;
    @NotEmpty
    @Size(min = 3, max = 15)
    private String prenom;
    @Temporal(TemporalType.DATE)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    @NotNull
    @DecimalMin("10")
    private int score;
    private boolean malade;
}
