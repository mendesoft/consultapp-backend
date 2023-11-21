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
import xyz.mendesoft.dto.EspecialidadDTO;
import xyz.mendesoft.model.Especialidad;
import xyz.mendesoft.service.IEspecialidadService;

import java.net.URI;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/examenes")
public class EspecialidadController {

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    private final IEspecialidadService service;

    @GetMapping
    public  ResponseEntity <List<EspecialidadDTO>> listar()  {
        List<EspecialidadDTO> lst = service.listar().stream().map(this::convertirToDto).toList();
        return new ResponseEntity<>(lst, HttpStatus.OK); //200
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadDTO> listarPorId(@PathVariable("id") Integer id)  {
        Especialidad obj = service.listarPorId(id);
        return new ResponseEntity<> (convertirToDto(obj), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EspecialidadDTO> registrar(@Valid @RequestBody EspecialidadDTO obj) {
        Especialidad p = service.registrar(convertirToEntity(obj));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdEspecialidad()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspecialidadDTO> modificar(@Valid @RequestBody EspecialidadDTO obj, @PathVariable("id") Integer id) throws Exception {
        Especialidad p = service.modificar(convertirToEntity(obj),id);
        return new ResponseEntity<> (convertirToDto(p), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable("id") Integer id) {
        service.eliminarPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
    }

    //Paginacion
      @GetMapping("/paginacion")
      public ResponseEntity<Page<EspecialidadDTO>> paginacion(Pageable pageable){
        Page<EspecialidadDTO> page = service.paginacion(pageable).map(p->mapper.map(p, EspecialidadDTO.class));
        return new ResponseEntity<>(page,HttpStatus.OK);
      }

    private EspecialidadDTO convertirToDto(Especialidad obj){
        return mapper.map(obj, EspecialidadDTO.class);
    }

    private Especialidad convertirToEntity(EspecialidadDTO dto){
        return mapper.map(dto, Especialidad.class);
    }
}
