package com.Fibra.treino.model;

import com.Fibra.usuario.model.Usuario;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "treinos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    private LocalDateTime dataCriacao = LocalDateTime.now();
    private LocalDateTime dataAtualizacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @PreUpdate
    public void preUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }
}