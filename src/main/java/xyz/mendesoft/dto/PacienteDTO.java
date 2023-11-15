package xyz.mendesoft.dto;


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

    private String nombres;

    private String apellidos;

    private String email;

    private String dni;
}
