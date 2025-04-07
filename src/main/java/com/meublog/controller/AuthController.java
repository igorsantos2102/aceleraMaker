package com.meublog.controller;

import java.util.Collections;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meublog.dto.UsuarioLoginDTO;
import com.meublog.model.Usuario;
import com.meublog.security.JwtUtils;
import com.meublog.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioLoginDTO dto) {

        Optional<Usuario> usuarioOpt = usuarioService.buscarPorEmail(dto.getEmail());
        if (usuarioOpt.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        Usuario usuario = usuarioOpt.get();


        if (!new BCryptPasswordEncoder().matches(dto.getSenha(), usuario.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }


        String token = usuarioService.gerarToken(usuario);
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }
}