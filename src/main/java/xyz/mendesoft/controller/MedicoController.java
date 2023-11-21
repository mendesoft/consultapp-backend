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
import xyz.mendesoft.dto.MedicoDTO;
import xyz.mendesoft.model.Medico;
import xyz.mendesoft.service.IMedicoService;

import java.net.URI;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    private final IMedicoService service;

    @GetMapping
    public  ResponseEntity <List<MedicoDTO>> listar()  {
        List<MedicoDTO> lst = service.listar().stream().map(this::convertirToDto).toList();
        return new ResponseEntity<>(lst, HttpStatus.OK); //200
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> listarPorId(@PathVariable("id") Integer id)  {
        Medico obj = service.listarPorId(id);
        return new ResponseEntity<> (convertirToDto(obj), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> registrar(@Valid @RequestBody MedicoDTO obj) {
        Medico p = service.registrar(convertirToEntity(obj));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdMedico()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoDTO> modificar(@Valid @RequestBody MedicoDTO obj, @PathVariable("id") Integer id) throws Exception {
        Medico p = service.modificar(convertirToEntity(obj),id);
        return new ResponseEntity<> (convertirToDto(p), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable("id") Integer id) {
        service.eliminarPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
    }

    //Paginacion
      @GetMapping("/paginacion")
      public ResponseEntity<Page<MedicoDTO>> paginacion(Pageable pageable){
        Page<MedicoDTO> page = service.paginacion(pageable).map(p->mapper.map(p, MedicoDTO.class));
        return new ResponseEntity<>(page,HttpStatus.OK);
      }

    private MedicoDTO convertirToDto(Medico obj){
        return mapper.map(obj, MedicoDTO.class);
    }

    private Medico convertirToEntity(MedicoDTO dto){
        return mapper.map(dto, Medico.class);
    }
}
