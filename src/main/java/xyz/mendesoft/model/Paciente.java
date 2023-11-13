package xyz.mendesoft.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaciente;

    @Size(min = 3, message = "Debe tener como minimo 3 caracteres")
    private String nombres;

    @NotEmpty
    @NotNull
    private String apellidos;

    @Email
    private String email;

    @Column(unique = true, length = 8, nullable = true)
    private String dni;

}
