package dio.desafio_design_pattern_spring.controller;

import dio.desafio_design_pattern_spring.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;

public class JogadorController {

    @Autowired
    private JogadorService jogadorService;
}
