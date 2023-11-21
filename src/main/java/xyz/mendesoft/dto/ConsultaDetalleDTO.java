package xyz.mendesoft.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ConsultaDetalleDTO {

    @EqualsAndHashCode.Include
    private Integer idDetalle;

    @JsonBackReference //REFERENCIA
    private ConsultaDTO consulta;

    @NotNull
    private String diagnostico;

    @NotNull
    private String tratamiento;
}
