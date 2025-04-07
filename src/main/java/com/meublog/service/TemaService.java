package com.meublog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meublog.model.Tema;
import com.meublog.repository.TemaRepository;

import java.util.List;

@Service
@Transactional
public class TemaService {
    @Autowired
    private TemaRepository repository;

    // Criar novo tema
    public Tema criar(Tema tema) {
        return repository.save(tema);
    }

    // Listar todos os temas
    public List<Tema> listarTodos() {
        return repository.findAll();
    }

    // Buscar por ID
    public Tema buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tema não encontrado"));
    }

    // Atualizar tema
    public Tema atualizar(Long id, Tema temaAtualizado) {
        Tema tema = buscarPorId(id);
        tema.setDescricao(temaAtualizado.getDescricao());
        return repository.save(tema);
    }

    // Excluir tema
    public void excluir(Long id) {
        Tema tema = buscarPorId(id);
        repository.delete(tema);
    }
}
