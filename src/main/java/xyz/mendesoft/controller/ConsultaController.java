package xyz.mendesoft.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import xyz.mendesoft.dto.ConsultaDTO;
import xyz.mendesoft.dto.ConsultaListExamenDTO;
import xyz.mendesoft.model.Consulta;
import xyz.mendesoft.model.Examen;
import xyz.mendesoft.service.IConsultaService;

import java.net.URI;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    private final IConsultaService service;

    @GetMapping
    public  ResponseEntity <List<ConsultaDTO>> listar()  {
        List<ConsultaDTO> lst = service.listar().stream().map(this::convertirToDto).toList();
        return new ResponseEntity<>(lst, HttpStatus.OK); //200
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> listarPorId(@PathVariable("id") Integer id)  {
        Consulta obj = service.listarPorId(id);
        return new ResponseEntity<> (convertirToDto(obj), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ConsultaDTO> registrar(@Valid @RequestBody ConsultaListExamenDTO dto) {
        Consulta cons = this.convertirToEntity(dto.getConsulta());
        List<Examen> exams = mapper.map(dto.getLstExamen(), new TypeToken<List<Examen>>(){}.getType());

        Consulta obj = service.registrarTransactional(cons, exams);

        //localhost:8080/consults/3
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdConsulta()).toUri();
        return ResponseEntity.created(location).build(); //.body(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDTO> modificar(@Valid @RequestBody ConsultaDTO obj, @PathVariable("id") Integer id) throws Exception {
        Consulta p = service.modificar(convertirToEntity(obj),id);
        return new ResponseEntity<> (convertirToDto(p), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable("id") Integer id) {
        service.eliminarPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
    }



    private ConsultaDTO convertirToDto(Consulta obj){
        return mapper.map(obj, ConsultaDTO.class);
    }

    private Consulta convertirToEntity(ConsultaDTO dto){
        return mapper.map(dto, Consulta.class);
    }
}
