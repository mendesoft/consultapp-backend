package xyz.mendesoft.controller;


import org.springframework.web.bind.annotation.*;
import xyz.mendesoft.model.Paciente;
import xyz.mendesoft.service.ICRUD;
import xyz.mendesoft.service.IPacienteService;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController{


    private final IPacienteService service;

    public PacienteController(IPacienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Paciente> listar() throws Exception {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Paciente listarPorId(@PathVariable("id") Integer id) throws Exception {
        return service.listarPorId(id);
    }

    @PostMapping
    public Paciente registrar(@RequestBody Paciente obj) throws Exception {
        return service.registrar(obj);
    }

    @PutMapping
    public Paciente modificar(@RequestBody Paciente obj) throws Exception {
        return service.modificar(obj);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable("id") Integer id) {
        service.eliminarPorId(id);
    }
}
