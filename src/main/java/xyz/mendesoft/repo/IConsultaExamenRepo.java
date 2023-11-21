package xyz.mendesoft.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xyz.mendesoft.model.ConsultaExamen;

import java.util.List;

public interface IConsultaExamenRepo extends IGenericRepo<ConsultaExamen,Integer> {

    //@Transactional
    @Modifying
    @Query(value = "INSERT INTO consulta_examen(id_consulta, id_examen) VALUES (:idConsulta, :idExamen)" , nativeQuery = true)
    Integer saveExam(@Param("idConsult") Integer idConsult, @Param("idExam") Integer idExam);

    @Query("SELECT new xyz.mendesoft.model.ConsultaExamen(ce.examen) FROM ConsultaExamen ce WHERE ce.consulta.idConsulta = :idConsulta")
    List<ConsultaExamen> getExamsByConsultId(@Param("idConsulta") Integer id);
}
