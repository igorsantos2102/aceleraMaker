package com.meublog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meublog.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long> {

}
