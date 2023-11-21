package xyz.mendesoft.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ConsultaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_consulta", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULTA_DETALLE"))
    private Consulta consulta;

    @Column(nullable = false, length = 70)
    private String diagnostico;

    @Column(nullable = false, length = 300)
    private String tratamiento;

}
