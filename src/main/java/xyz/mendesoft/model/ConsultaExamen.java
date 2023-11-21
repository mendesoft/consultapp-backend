package xyz.mendesoft.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(ConsultaExamenPK.class)
public class ConsultaExamen {

    @Id
    private Consulta consulta;

    @Id
    private Examen examen;
}
