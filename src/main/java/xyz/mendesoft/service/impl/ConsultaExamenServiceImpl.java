package xyz.mendesoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.mendesoft.model.ConsultaExamen;
import xyz.mendesoft.repo.IConsultaExamenRepo;
import xyz.mendesoft.service.IConsultaExamenService;
import xyz.mendesoft.service.IConsultaService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaExamenServiceImpl implements IConsultaExamenService {

    private final IConsultaExamenRepo repo;


    @Override
    public List<ConsultaExamen> getExamsByConsultId(Integer idConsulta) {
        return repo.getExamsByConsultId(idConsulta);
    }
}
