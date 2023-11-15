package xyz.mendesoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.mendesoft.model.Paciente;
import xyz.mendesoft.repo.IGenericRepo;
import xyz.mendesoft.repo.IPacienteRepo;
import xyz.mendesoft.service.IPacienteService;

@RequiredArgsConstructor
@Service
public class PacienteServiceImpl extends CRUDImpl<Paciente,Integer> implements IPacienteService  {


    private final IPacienteRepo repo;


    @Override
    protected IGenericRepo<Paciente, Integer> getRepo() {
        return repo;
    }
}
