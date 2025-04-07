package com.meublog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meublog.model.Postagem;

import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    List<Postagem> findByTituloContaining(String titulo);
    List<Postagem> findByUsuarioId(Long usuarioId);
    List<Postagem> findByTemaId(Long temaId);
}