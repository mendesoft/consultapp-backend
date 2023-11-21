package xyz.mendesoft.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.mendesoft.model.Especialidad;

public interface IEspecialidadService extends ICRUD<Especialidad, Integer>{

    Page<Especialidad> paginacion(Pageable pageable);
}
