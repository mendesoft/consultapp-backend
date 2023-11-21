package xyz.mendesoft.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.mendesoft.model.Medico;

public interface IMedicoService extends ICRUD<Medico, Integer>{

    Page<Medico> paginacion(Pageable pageable);
}
