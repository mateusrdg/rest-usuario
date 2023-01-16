package br.com.usuario.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UsuarioDto {

    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String senha;
    @NotBlank
    private String email;

    private Set<PerfilDto> perfis = new HashSet<>();
}
