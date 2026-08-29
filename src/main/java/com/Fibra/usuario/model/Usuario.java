package com.Fibra.usuario.model;

import com.Fibra.treino.model.Treino;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Padronizado como id

    @Column(nullable = false)
    private String nome; // Padronizado como nome

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private int idade;
    private Double peso;
    private Double altura;
    private String genero;

    private Boolean role;

    @ElementCollection
    private List<String> unidadeMedida;

    private Boolean enabled;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Treino> treinos = new ArrayList<>();
}
