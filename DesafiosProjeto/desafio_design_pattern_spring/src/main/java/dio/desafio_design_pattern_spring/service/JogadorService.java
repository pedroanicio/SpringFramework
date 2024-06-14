package dio.desafio_design_pattern_spring.service;

import dio.desafio_design_pattern_spring.model.Jogador;
import dio.desafio_design_pattern_spring.model.Time;

import java.util.List;

public interface JogadorService {


    Iterable<Jogador> buscarTodos();

    Jogador buscarPorId(Long id);

    List<Jogador> buscarPorTime(Time time);

    List <Jogador> buscarPorPosicao(String posicao);

    void inserir(Jogador jogador);

    void atualizar(Long id, Jogador jliente);

    void deletar(Long id);
}
