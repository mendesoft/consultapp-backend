package xyz.mendesoft.controller;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.mendesoft.dto.ConsultaExamenDTO;
import xyz.mendesoft.model.ConsultaExamen;
import xyz.mendesoft.service.IConsultaExamenService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/consultaexmanes")
public class ConsultaExamenController {

    @Qualifier("defaultMapper")
    private final ModelMapper mapper;
    private IConsultaExamenService service;

    @GetMapping("/{idConsulta}")
    public ResponseEntity<List<ConsultaExamenDTO>> getConsultsById(@PathVariable("idConsulta") Integer idConsult) {
        List<ConsultaExamen> lst = service.getExamsByConsultId(idConsult);
        List<ConsultaExamenDTO> lstDTO = mapper.map(lst, new TypeToken<List<ConsultaExamenDTO>>() {}.getType());

        return new ResponseEntity<>(lstDTO, HttpStatus.OK);
    }

}
