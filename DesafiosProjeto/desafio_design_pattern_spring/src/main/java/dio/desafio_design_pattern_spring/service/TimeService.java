package dio.desafio_design_pattern_spring.service;

import dio.desafio_design_pattern_spring.model.Time;

public interface TimeService {
    Iterable<Time> buscarTodos();
    Time buscarPorId(Long id);
    void criar(Time time);
    void atualizar(Long id, Time time);
    void deletar(Long id);
}
