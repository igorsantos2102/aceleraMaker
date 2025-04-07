package com.meublog.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.meublog.model.Postagem;

import com.meublog.service.PostagemService;

@RestController
@RequestMapping("/api/postagens")
public class PostagemController {
    @Autowired
    private PostagemService service;

    @GetMapping
    public ResponseEntity<List<Postagem>> listarTodas() {
    	
        return ResponseEntity.ok(service.listarTodas());
    }
}
