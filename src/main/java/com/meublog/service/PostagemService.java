package com.meublog.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meublog.model.Postagem;
import com.meublog.model.Tema;
import com.meublog.model.Usuario;
import com.meublog.repository.PostagemRepository;
import com.meublog.repository.TemaRepository;
import com.meublog.repository.UsuarioRepository;

import java.util.List;


@Service
@Transactional
public class PostagemService {
    @Autowired
    private PostagemRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TemaRepository temaRepository;

    public Postagem criar(Postagem postagem) {
        Usuario usuario = usuarioRepository.findById(postagem.getUsuario().getId())
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Tema tema = temaRepository.findById(postagem.getTema().getId())
            .orElseThrow(() -> new RuntimeException("Tema não encontrado"));
        postagem.setUsuario(usuario);
        postagem.setTema(tema);
        return repository.save(postagem);
    }

    // Buscar todas as postagens
    @Transactional(readOnly = true) 
    public List<Postagem> listarTodas() {
        return repository.findAll();
    }

    // Buscar por ID
    public Postagem buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Postagem não encontrada"));
    }

    // Atualizar postagem
    public Postagem atualizar(Long id, Postagem postagemAtualizada) {
        Postagem postagem = buscarPorId(id);
        postagem.setTitulo(postagemAtualizada.getTitulo());
        postagem.setTexto(postagemAtualizada.getTexto());
        postagem.setTema(postagemAtualizada.getTema());
        return repository.save(postagem);
    }

    // Excluir postagem
    public void excluir(Long id) {
        Postagem postagem = buscarPorId(id);
        repository.delete(postagem);
    }
    
    
}