package xyz.mendesoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xyz.mendesoft.model.Especialidad;
import xyz.mendesoft.repo.IEspecialidadRepo;
import xyz.mendesoft.repo.IGenericRepo;
import xyz.mendesoft.service.IEspecialidadService;

@RequiredArgsConstructor
@Service
public class EspecialidadServiceImpl extends CRUDImpl<Especialidad,Integer> implements IEspecialidadService  {


    private final IEspecialidadRepo repo;


    @Override
    protected IGenericRepo<Especialidad, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Especialidad> paginacion(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
