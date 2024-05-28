package com.uri.pw.services;

import com.uri.pw.entities.Tarefa;
import com.uri.pw.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    public List<Tarefa> findAll() {
        return repository.findAll();
    }

    public Tarefa findTarefa(Long id) {
        // return repository.findById(id).stream().findFirst().get();
        Optional<Tarefa> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new RuntimeException();
    }

    public Tarefa create(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public Tarefa update(Long id, Tarefa tarefa) {
        Tarefa tarefaAtual = findTarefa(id);
        tarefaAtual.setDescricao(tarefa.getDescricao());
        tarefaAtual.setDataCriacao(tarefa.getDataCriacao());
        tarefaAtual.setDataLimite(tarefa.getDataLimite());
        tarefaAtual.setFinalizada(true);
        return repository.save(tarefaAtual);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}