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
import xyz.mendesoft.dto.ExamenDTO;
import xyz.mendesoft.model.Examen;
import xyz.mendesoft.service.IExamenService;

import java.net.URI;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/examenes")
public class ExmenController {

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    private final IExamenService service;

    @GetMapping
    public  ResponseEntity <List<ExamenDTO>> listar()  {
        List<ExamenDTO> lst = service.listar().stream().map(this::convertirToDto).toList();
        return new ResponseEntity<>(lst, HttpStatus.OK); //200
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamenDTO> listarPorId(@PathVariable("id") Integer id)  {
        Examen obj = service.listarPorId(id);
        return new ResponseEntity<> (convertirToDto(obj), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExamenDTO> registrar(@Valid @RequestBody ExamenDTO obj) {
        Examen p = service.registrar(convertirToEntity(obj));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdExamen()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamenDTO> modificar(@Valid @RequestBody ExamenDTO obj, @PathVariable("id") Integer id) throws Exception {
        Examen p = service.modificar(convertirToEntity(obj),id);
        return new ResponseEntity<> (convertirToDto(p), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable("id") Integer id) {
        service.eliminarPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
    }

    //Paginacion
      @GetMapping("/paginacion")
      public ResponseEntity<Page<ExamenDTO>> paginacion(Pageable pageable){
        Page<ExamenDTO> page = service.paginacion(pageable).map(p->mapper.map(p, ExamenDTO.class));
        return new ResponseEntity<>(page,HttpStatus.OK);
      }

    private ExamenDTO convertirToDto(Examen obj){
        return mapper.map(obj, ExamenDTO.class);
    }

    private Examen convertirToEntity(ExamenDTO dto){
        return mapper.map(dto, Examen.class);
    }
}
