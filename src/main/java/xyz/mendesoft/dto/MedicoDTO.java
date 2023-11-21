package xyz.mendesoft.dto;

import jakarta.persistence.Column;

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
public class MedicoDTO {


    private Integer idMedico;

    @Size(min = 3, max = 50, message = "3 caracteres")
    private String nombres;

    @Size(min = 3, max = 50, message = "3 caracteres")
    private String apellidos;

    private String foto;

    @NotEmpty
    @NotNull
    private String carnet;
}
