package dio.desafio_design_pattern_spring.repository;

import dio.desafio_design_pattern_spring.model.Jogador;
import dio.desafio_design_pattern_spring.model.Time;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogadorRepository extends CrudRepository<Jogador, Long> {
    List<Jogador> findByTime(Time time);
}
