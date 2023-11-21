package xyz.mendesoft.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import xyz.mendesoft.model.ConsultaDetalle;
import xyz.mendesoft.model.Especialidad;
import xyz.mendesoft.model.Medico;
import xyz.mendesoft.model.Paciente;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ConsultaDTO {

    private Integer idConsulta;

    @NotNull
    private Paciente paciente;

    @NotNull
    private Medico medico;

    @NotNull
    private Especialidad especialidad;

    @NotNull
    private String numConsulta;


    private LocalDateTime fecha;


    private List<ConsultaDetalle> detalle;


}
