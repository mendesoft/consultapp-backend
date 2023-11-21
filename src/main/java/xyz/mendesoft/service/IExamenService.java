package xyz.mendesoft.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.mendesoft.model.Examen;

public interface IExamenService extends ICRUD<Examen, Integer>{

    Page<Examen> paginacion(Pageable pageable);
}
