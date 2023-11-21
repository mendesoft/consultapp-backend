package xyz.mendesoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xyz.mendesoft.model.Examen;
import xyz.mendesoft.repo.IGenericRepo;
import xyz.mendesoft.repo.IExamenRepo;
import xyz.mendesoft.service.IExamenService;

@RequiredArgsConstructor
@Service
public class ExamenServiceImpl extends CRUDImpl<Examen,Integer> implements IExamenService  {


    private final IExamenRepo repo;


    @Override
    protected IGenericRepo<Examen, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Examen> paginacion(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
