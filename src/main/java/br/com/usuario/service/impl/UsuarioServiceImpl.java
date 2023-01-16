package br.com.usuario.service.impl;

import br.com.usuario.model.Usuario;
import br.com.usuario.model.dto.UsuarioDto;
import br.com.usuario.repository.UsuarioRepository;
import br.com.usuario.service.UsuarioService;
import br.com.usuario.service.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private ModelMapper modelMapper;
    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public Usuario buscarPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            throw new ObjectNotFoundException("Email não existe! email: " + email);
        }
        return usuario;
    }

    @Override
    public Usuario buscarPorid(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.orElseThrow(() -> new ObjectNotFoundException("Usuario não existe! id: " + id));
    }

    @Override
    public Usuario inserir(UsuarioDto usuarioDto) {
        String senha = usuarioDto.getSenha();
        System.out.println(senha);
        String senhaCriptografada = passwordEncoder.encode(senha);
        System.out.println(senhaCriptografada);
        usuarioDto.setSenha(senhaCriptografada);
        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
        return usuarioRepository.save(usuario);
    }
}
