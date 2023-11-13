package xyz.mendesoft.controller;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.mendesoft.model.Paciente;
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
    public  ResponseEntity <List<Paciente>> listar() throws Exception {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK); //200
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> listarPorId(@PathVariable("id") Integer id) throws Exception {

        return new ResponseEntity<> (service.listarPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Paciente> registrar(@Valid @RequestBody Paciente obj) throws Exception {
        return new ResponseEntity<> (service.registrar(obj), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Paciente> modificar(@Valid @RequestBody Paciente obj) throws Exception {
        return new ResponseEntity<> (service.modificar(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable("id") Integer id) {
        service.eliminarPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
    }
}
