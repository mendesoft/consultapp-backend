package xyz.mendesoft.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PacienteDTO {

    private Integer idPaciente;

    @Size(min = 3, message = "Debe tener como minimo 3 caracteres")
    private String nombres;

    @NotEmpty
    @NotNull
    private String apellidos;

    @Email
    private String email;

    private String dni;
}
