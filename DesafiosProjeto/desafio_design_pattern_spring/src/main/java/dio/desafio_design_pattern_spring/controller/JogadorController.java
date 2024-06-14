package dio.desafio_design_pattern_spring.controller;

import dio.desafio_design_pattern_spring.model.Jogador;
import dio.desafio_design_pattern_spring.model.Time;
import dio.desafio_design_pattern_spring.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class JogadorController {

    @Autowired
    private JogadorService jogadorService;


    @GetMapping
    public ResponseEntity<Iterable <Jogador>> buscarTodos(){
        return ResponseEntity.ok(jogadorService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(jogadorService.buscarPorId(id));
    }
    @GetMapping("/{time}")
    public ResponseEntity<List<Jogador>> buscarPorTime(@PathVariable Time time){
        return ResponseEntity.ok(jogadorService.buscarPorTime(time));
    }
    
    @GetMapping("/{posicao}")
    public ResponseEntity<List<Jogador>> buscarPorPosicao(@PathVariable String posicao){
        return ResponseEntity.ok(jogadorService.buscarPorPosicao(posicao));
    }
    
    @PostMapping

    @PutMapping

    @DeleteMapping
    
}
