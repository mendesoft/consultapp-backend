package xyz.mendesoft.service.impl;

import org.springframework.stereotype.Service;
import xyz.mendesoft.model.Paciente;
import xyz.mendesoft.repo.IGenericRepo;
import xyz.mendesoft.repo.IPacienteRepo;
import xyz.mendesoft.service.IPacienteService;

@Service
public class PacienteServiceImpl extends CRUDImpl<Paciente,Integer> implements IPacienteService  {


    private final IPacienteRepo repo;

    public PacienteServiceImpl(IPacienteRepo repo) {
        this.repo = repo;
    }

    @Override
    protected IGenericRepo<Paciente, Integer> getRepo() {
        return repo;
    }
}
