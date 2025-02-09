package com.kodi.catalogo_api.controller;


import com.kodi.catalogo_api.controller.dto.UsuarioRequestDto;
import com.kodi.catalogo_api.controller.dto.UsuarioResponseDto;
import com.kodi.catalogo_api.controller.dto.mapper.UsuarioMapper;
import com.kodi.catalogo_api.entity.Usuario;
import com.kodi.catalogo_api.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> criarUsuario(@Valid @RequestBody UsuarioRequestDto dto) {
        Usuario user = usuarioService.criarUsuario(UsuarioMapper.toUsuario(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }
}
