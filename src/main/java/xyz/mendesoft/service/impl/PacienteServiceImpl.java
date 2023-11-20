package xyz.mendesoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Paciente> paginacion(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
