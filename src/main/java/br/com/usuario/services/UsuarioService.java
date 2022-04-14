package br.com.usuario.services;

import br.com.usuario.model.Usuario;

public interface UsuarioService {

    Usuario buscarPorEmail(String email);

    Usuario buscarPorid(Long id);

    Usuario inserir(Usuario usuario);
}
