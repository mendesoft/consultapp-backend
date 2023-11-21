package xyz.mendesoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xyz.mendesoft.model.Medico;
import xyz.mendesoft.repo.IGenericRepo;
import xyz.mendesoft.repo.IMedicoRepo;
import xyz.mendesoft.service.IMedicoService;

@RequiredArgsConstructor
@Service
public class MedicoServiceImpl extends CRUDImpl<Medico,Integer> implements IMedicoService  {


    private final IMedicoRepo repo;


    @Override
    protected IGenericRepo<Medico, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Medico> paginacion(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
