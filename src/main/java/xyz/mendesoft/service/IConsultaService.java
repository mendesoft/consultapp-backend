package xyz.mendesoft.service;

import xyz.mendesoft.dto.ConsultaProcDTO;
import xyz.mendesoft.model.Consulta;
import xyz.mendesoft.model.Examen;

import java.time.LocalDateTime;
import java.util.List;

public interface IConsultaService extends ICRUD<Consulta, Integer>{
    Consulta registrarTransactional(Consulta consult, List<Examen> exams);

    List<Consulta> buscar(String dni, String fullname);
    List<Consulta> buscarPorFechas(LocalDateTime date1, LocalDateTime date2);
    List<ConsultaProcDTO> callProcedureOrFunctionNative();
    List<ConsultaProcDTO> callProcedureOrFunctionProjection();
    byte[] generateReport() throws Exception;

}
