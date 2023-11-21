package xyz.mendesoft.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaListExamenDTO {

    @NotNull
    private ConsultaDTO consulta;

    @NotNull
    private List<ExamenDTO> lstExamen;

}
