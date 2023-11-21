package xyz.mendesoft.repo;

import xyz.mendesoft.dto.ConsultaProcDTO;
import xyz.mendesoft.model.Consulta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
public interface IConsultaRepo extends IGenericRepo<Consulta,Integer> {
    @Query("FROM Consulta c WHERE c.paciente.dni = :dni OR LOWER(c.paciente.nombres) LIKE %:fullname% OR LOWER(c.paciente.apellidos) LIKE %:fullname%")
    List<Consulta> buscar(@Param("dni") String dni, @Param("fullname") String fullname);

    // >=       |   <
    //15-09-23 al 30-09-23
    @Query("FROM Consulta c WHERE c.fecha BETWEEN :date1 AND :date2")
    List<Consulta> buscarPorFechas(@Param("date1") LocalDateTime date1, @Param("date2") LocalDateTime date2);

    @Query(value = "select * from fn_list()", nativeQuery = true)
    List<Object[]> callProcedureOrFunctionNative();


    @Query(value = "select * from fn_list()", nativeQuery = true)
    List<ConsultaProcDTO> callProcedureOrFunctionProjection();
}
