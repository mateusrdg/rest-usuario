package br.com.usuario.services.Impl;

import br.com.usuario.model.Usuario;
import br.com.usuario.repositories.UsuarioRepository;
import br.com.usuario.services.UsuarioService;
import br.com.usuario.services.exceptions.DataIntegratyViolationException;
import br.com.usuario.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario buscarPorEmail(String email) {
        Usuario usuario = this.usuarioRepository.findByEmail(email);
        if (usuario == null) {
            throw new ObjectNotFoundException("Email não existe! " + email);
        }
        return usuario;
    }

    @Override
    public Usuario buscarPorid(Long id) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new ObjectNotFoundException(
                "Usuario não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
    }

    @Override
    public Usuario inserir(Usuario usuario) {
        Usuario byEmail = usuarioRepository.findByEmail(usuario.getEmail());
        if (byEmail == null)
            return this.usuarioRepository.save(usuario);
        throw new DataIntegratyViolationException("Email já existe! " + usuario.getEmail());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = buscarPorEmail(username);
        if (usuario == null) {
            throw new IllegalArgumentException("Email não encontrado");
        }
        return usuario;
    }
}
