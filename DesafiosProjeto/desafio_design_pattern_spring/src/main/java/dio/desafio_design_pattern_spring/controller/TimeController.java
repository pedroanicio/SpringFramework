package dio.desafio_design_pattern_spring.controller;

import dio.desafio_design_pattern_spring.model.Time;
import dio.desafio_design_pattern_spring.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("times")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping
    public ResponseEntity<Iterable<Time>> buscarTodos() {
        return ResponseEntity.ok(timeService.buscarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Time> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(timeService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Time> criar(@RequestBody Time time){
        timeService.criar(time);
        return ResponseEntity.ok(time);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Time> atualizar(@PathVariable Long id, @RequestBody Time time){
        timeService.atualizar(id, time);
        return ResponseEntity.ok(time);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        timeService.deletar(id);
        return ResponseEntity.ok().build();
    }


}
