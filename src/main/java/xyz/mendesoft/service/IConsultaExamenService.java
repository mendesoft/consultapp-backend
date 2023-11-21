package xyz.mendesoft.service;

import xyz.mendesoft.model.ConsultaExamen;

import java.util.List;

public interface IConsultaExamenService{
    List<ConsultaExamen> getExamsByConsultId(Integer idConsult);
}
