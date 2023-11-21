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
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idConsulta;

    @ManyToOne //FK
    @JoinColumn(name = "id_paciente", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULTA_PACIENTE"))
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULTA_MEDICO"))
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_especialidad", nullable = false, foreignKey = @ForeignKey(name = "FK_CONSULTA_ESPECIALIDAD"))
    private Especialidad especialidad;

    @Column(length = 3, nullable = false)
    private String numConsulta;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, orphanRemoval = true) //fetch = FetchType.EAGER)
    private List<ConsultaDetalle> detalle;

}
