package dio.desafio_design_pattern_spring.repository;

import dio.desafio_design_pattern_spring.model.Jogador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends CrudRepository<Jogador, Long> {}
