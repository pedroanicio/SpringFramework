package dio.desafio_design_pattern_spring.repository;

import dio.desafio_design_pattern_spring.model.Time;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends CrudRepository<Time, Long> {}
