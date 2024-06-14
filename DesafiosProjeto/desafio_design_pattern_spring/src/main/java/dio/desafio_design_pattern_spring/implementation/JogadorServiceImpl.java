package dio.desafio_design_pattern_spring.implementation;

import dio.desafio_design_pattern_spring.model.Jogador;
import dio.desafio_design_pattern_spring.model.Time;
import dio.desafio_design_pattern_spring.repository.JogadorRepository;
import dio.desafio_design_pattern_spring.repository.TimeRepository;
import dio.desafio_design_pattern_spring.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorServiceImpl implements JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private TimeRepository timeRepository;

    @Override
    public Iterable<Jogador> buscarTodos() {
        return jogadorRepository.findAll();
    }

    @Override
    public Jogador buscarPorId(Long id) {
        Optional<Jogador> jogador = jogadorRepository.findById(id);
        return jogador.get();
    }

    @Override
    public List<Jogador> buscarPorTime(Time time) {
        return jogadorRepository.findByTime(time);
    }

    @Override
    public List<Jogador> buscarPorPosicao(String posicao) {
        return null;
    }

    @Override
    public void inserir(Jogador jogador) {
        salvar(jogador);
    }

    @Override
    public void atualizar(Long id, Jogador jogador) {
        Optional<Jogador> jog = jogadorRepository.findById(id);

        if (jog.isPresent()){
            salvar(jogador);
        }
    }

    @Override
    public void deletar(Long id) {
        jogadorRepository.deleteById(id);
    }

    public void salvar(Jogador jogador){
        jogadorRepository.save(jogador);
    }
}
