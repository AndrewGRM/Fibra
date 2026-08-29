package com.Fibra.usuario.dto;

import com.Fibra.usuario.model.Usuario;
import java.util.List;

public record UsuarioResponse(
        Long id,
        String nome,
        String email,
        int idade,
        Double peso,
        Double altura,
        String genero,
        Boolean role,
        List<String> unidadeMedida,
        Boolean enabled
) {
    public UsuarioResponse(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getIdade(),
                usuario.getPeso(),
                usuario.getAltura(),
                usuario.getGenero(),
                usuario.getRole(),
                usuario.getUnidadeMedida(),
                usuario.getEnabled()
        );
    }
}
