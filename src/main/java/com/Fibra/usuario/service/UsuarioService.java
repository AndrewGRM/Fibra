package com.Fibra.usuario.service;

import com.Fibra.usuario.dto.UsuarioRequest;
import com.Fibra.usuario.dto.UsuarioResponse;
import com.Fibra.usuario.model.Usuario;
import com.Fibra.usuario.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public List<UsuarioResponse> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioResponse::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public UsuarioResponse buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id: " + id));
        return new UsuarioResponse(usuario);
    }

    @Transactional
    public UsuarioResponse criar(UsuarioRequest dto) {
        if (usuarioRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("E-mail já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setPassword(dto.senha()); // Usa setPassword correspondente à entidade

        Usuario salvo = usuarioRepository.save(usuario);
        return new UsuarioResponse(salvo);
    }

    @Transactional
    public UsuarioResponse atualizar(Long id, UsuarioRequest dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id: " + id));

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setPassword(dto.senha());

        Usuario atualizado = usuarioRepository.save(usuario);
        return new UsuarioResponse(atualizado);
    }

    @Transactional
    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado com id: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}