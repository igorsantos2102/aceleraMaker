package com.meublog.model;

import lombok.Data;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Data 
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Título obrigatório")
    private String titulo;

    @NotBlank(message = "Texto obrigatório")
    private String texto;

    private LocalDateTime data = LocalDateTime.now();

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "tema_id")
    private Tema tema;
}