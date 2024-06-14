package dio.desafio_design_pattern_spring.service;

import dio.desafio_design_pattern_spring.model.Jogador;
import dio.desafio_design_pattern_spring.model.Time;

public interface JogadorService {


    Iterable<Jogador> buscarTodos();

    Jogador buscarPorId(Long id);

    Jogador buscarPorTime(Time time);

    Jogador buscarPorPosicao(String posicao);

    void inserir(Jogador jogador);

    void atualizar(Long id, Jogador jliente);

    void deletar(Long id);
}
