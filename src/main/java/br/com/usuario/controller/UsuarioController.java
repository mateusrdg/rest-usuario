package br.com.usuario.controller;

import br.com.usuario.model.Usuario;
import br.com.usuario.model.dto.UsuarioDto;
import br.com.usuario.service.impl.UsuarioServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioServiceImpl usuarioService;

    @GetMapping("/email")
    public ResponseEntity<Usuario> buscarPorEmai(@RequestParam String email) {
        return ResponseEntity.ok(usuarioService.buscarPorEmail(email));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorid(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> inserir(@RequestBody @Valid UsuarioDto usuarioDto) {
        return ResponseEntity.ok(usuarioService.inserir(usuarioDto));
    }
}
