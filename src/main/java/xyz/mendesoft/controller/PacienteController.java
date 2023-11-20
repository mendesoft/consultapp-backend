package xyz.mendesoft.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import xyz.mendesoft.dto.PacienteDTO;
import xyz.mendesoft.model.Paciente;
import xyz.mendesoft.service.IPacienteService;

import java.net.URI;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/pacientes")
public class PacienteController{

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    private final IPacienteService service;

    @GetMapping
    public  ResponseEntity <List<PacienteDTO>> listar()  {
        List<PacienteDTO> lst = service.listar().stream().map(this::convertirToDto).toList();
        return new ResponseEntity<>(lst, HttpStatus.OK); //200
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> listarPorId(@PathVariable("id") Integer id)  {
        Paciente obj = service.listarPorId(id);
        return new ResponseEntity<> (convertirToDto(obj), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> registrar(@Valid @RequestBody PacienteDTO obj) {
        Paciente p = service.registrar(convertirToEntity(obj));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdPaciente()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> modificar(@Valid @RequestBody PacienteDTO obj, @PathVariable("id") Integer id) throws Exception {
        Paciente p = service.modificar(convertirToEntity(obj),id);
        return new ResponseEntity<> (convertirToDto(p), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable("id") Integer id) {
        service.eliminarPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
    }

    //Paginacion
      @GetMapping("/paginacion")
      public ResponseEntity<Page<PacienteDTO>> paginacion(Pageable pageable){
        Page<PacienteDTO> page = service.paginacion(pageable).map(p->mapper.map(p, PacienteDTO.class));
        return new ResponseEntity<>(page,HttpStatus.OK);
      }

    private PacienteDTO convertirToDto(Paciente obj){
        return mapper.map(obj, PacienteDTO.class);
    }

    private Paciente convertirToEntity(PacienteDTO dto){
        return mapper.map(dto, Paciente.class);
    }
}
