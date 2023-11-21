package xyz.mendesoft.model;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class ConsultaExamenPK {

    @ManyToOne
    @JoinColumn(name = "id_consulta", nullable = false)
    private Consulta consulta;

    @ManyToOne
    @JoinColumn(name = "id_examen", nullable = false)
    private Examen examen;
}
