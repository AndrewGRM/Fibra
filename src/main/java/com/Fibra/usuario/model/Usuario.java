package com.Fibra.usuario.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    // Utilizar um numero de matricula auto gerado pelo banco ou CPF
    Integer matricula;

    String username;

    String email;
    //Trocar para tipo para password em breve
    String password;

    int idade;

    Double peso;

    Double altura;

    String genero;

    Boolean role; // ADMIN, USER

    List<String> unidadeMedida;

    private Boolean enabled;
}
