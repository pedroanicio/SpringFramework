package dio.desafio_design_pattern_spring.implementation;

import dio.desafio_design_pattern_spring.model.Time;
import dio.desafio_design_pattern_spring.repository.TimeRepository;
import dio.desafio_design_pattern_spring.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    private TimeRepository timeRepository;


    @Override
    public Iterable<Time> buscarTodos() {
        return timeRepository.findAll();
    }

    @Override
    public Time buscarPorId(Long id) {
        Optional<Time> time = timeRepository.findById(id); //pode existir ou nao
        return time.get();
    }

    @Override
    public void criar(Time time) {
        salvar(time);
    }

    @Override
    public void atualizar(Long id, Time time) {
        Optional<Time> timebd = timeRepository.findById(id);

        if (timebd.isPresent()){
            salvar(time);
        }
    }

    @Override
    public void deletar(Long id) {
        timeRepository.deleteById(id);
    }

    private void salvar(Time time){
        timeRepository.save(time);
    }
}
