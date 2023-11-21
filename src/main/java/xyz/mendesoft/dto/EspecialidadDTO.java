package xyz.mendesoft.dto;


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
public class EspecialidadDTO {


    private Integer IdEspecialidad;

    @Size(min = 3, message = "Debe tener como minimo 3 caracteres")
    private String nombre;
}
