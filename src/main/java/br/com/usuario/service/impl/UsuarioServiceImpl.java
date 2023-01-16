package br.com.usuario.service.impl;

import br.com.usuario.model.Usuario;
import br.com.usuario.repository.UsuarioRepository;
import br.com.usuario.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;


    @Override
    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public Usuario buscarPorid(Long id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public Usuario inserir(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
