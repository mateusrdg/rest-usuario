package br.com.usuario.service;

import br.com.usuario.model.Usuario;
import br.com.usuario.model.dto.UsuarioDto;

public interface UsuarioService {

    Usuario buscarPorEmail(String email);

    Usuario buscarPorid(Long id);

    Usuario inserir(UsuarioDto usuario);
}
