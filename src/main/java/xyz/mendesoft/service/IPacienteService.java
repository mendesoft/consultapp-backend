package xyz.mendesoft.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.mendesoft.model.Paciente;

public interface IPacienteService extends ICRUD<Paciente, Integer>{

    Page<Paciente> paginacion(Pageable pageable);
}
