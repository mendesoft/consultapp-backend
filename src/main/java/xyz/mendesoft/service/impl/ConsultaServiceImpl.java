package xyz.mendesoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.mendesoft.dto.ConsultaProcDTO;
import xyz.mendesoft.model.Consulta;
import xyz.mendesoft.model.Examen;
import xyz.mendesoft.repo.IConsultaExamenRepo;
import xyz.mendesoft.repo.IConsultaRepo;
import xyz.mendesoft.repo.IGenericRepo;
import xyz.mendesoft.service.IConsultaService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ConsultaServiceImpl extends CRUDImpl<Consulta,Integer> implements IConsultaService {

    private final IConsultaRepo repo;
    private final IConsultaExamenRepo ceRepo;


    @Override
    protected IGenericRepo<Consulta, Integer> getRepo() {
        return repo;
    }


    @Transactional
    @Override
    public Consulta registrarTransactional(Consulta consulta, List<Examen> exams) {

        repo.save(consulta);
        exams.forEach(ex -> ceRepo.registrarExamen(consulta.getIdConsulta(),ex.getIdExamen()));
        return consulta;
    }

    @Override
    public List<Consulta> buscar(String dni, String fullname) {
        return repo.buscar(dni, fullname);
    }

    @Override
    public List<Consulta> buscarPorFechas(LocalDateTime date1, LocalDateTime date2) {
        return repo.buscarPorFechas(date1,date2);
    }

    @Override
    public List<ConsultaProcDTO> callProcedureOrFunctionNative() {
        List<ConsultaProcDTO> lst = new ArrayList<>();

        /*
        [3,	"02/09/2023"]
        [2,	"23/09/2023"]
         */

        repo.callProcedureOrFunctionNative().forEach(e -> {
            ConsultaProcDTO dto = new ConsultaProcDTO();
            dto.setCantidad((Integer) e[0]);
            dto.setFecha((String) e[1]);

            lst.add(dto);
        });

        return lst;
    }

    @Override
    public List<ConsultaProcDTO> callProcedureOrFunctionProjection() {
        return repo.callProcedureOrFunctionProjection();
    }

    @Override
    public byte[] generateReport() throws Exception {
        byte[] data = null;

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("txt_title", "Report Title");

        File file = new ClassPathResource("/reports/consultasR.jasper").getFile();
        JasperPrint print = JasperFillManager.fillReport(file.getPath(), parameters, new JRBeanCollectionDataSource(callProcedureOrFunctionNative()));
        data = JasperExportManager.exportReportToPdf(print);

        return data;
    }


}
