package xyz.mendesoft.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xyz.mendesoft.model.Consulta;
import xyz.mendesoft.model.Examen;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsultaExamenDTO {
    private ConsultaDTO consulta;
    private ExamenDTO examen;

}
