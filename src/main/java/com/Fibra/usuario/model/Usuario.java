package com.Fibra.usuario.model;

import com.Fibra.treino.model.Treino;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricula; // Chave primária (PK)

    private String username;
    private String email;
    private String password;

    private int idade;
    private Double peso;
    private Double altura;
    private String genero;

    private Boolean role;

    @ElementCollection
    private List<String> unidadeMedida;

    private Boolean enabled;

    // Relacionamento 1:N -> Um usuário possui vários treinos
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Treino> treinos = new ArrayList<>();
}
