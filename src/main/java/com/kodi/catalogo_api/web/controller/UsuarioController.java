package com.kodi.catalogo_api.web.controller;


import com.kodi.catalogo_api.web.dto.DataNascimentoUpdateRequestDto;
import com.kodi.catalogo_api.web.dto.UsuarioCreateRequestDto;
import com.kodi.catalogo_api.web.dto.UsuarioResponseDto;
import com.kodi.catalogo_api.web.dto.SenhaUpdateRequestDto;
import com.kodi.catalogo_api.web.dto.mapper.UsuarioMapper;
import com.kodi.catalogo_api.entity.Usuario;
import com.kodi.catalogo_api.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/incluir")
    public ResponseEntity<UsuarioResponseDto> criarUsuario(@Valid @RequestBody UsuarioCreateRequestDto dto) {
        Usuario user = usuarioService.criarUsuario(UsuarioMapper.toUsuario(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<UsuarioResponseDto> listarUsuario(@PathVariable Long id) {
        Usuario user = usuarioService.listarUsuario(id);
        return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<UsuarioResponseDto>> listarTodosUsuarios() {
        List<Usuario> user = usuarioService.listarTodosUsuarios();
        return ResponseEntity.ok(UsuarioMapper.toListDto(user));
    }
    @PatchMapping("/editarSenha/{id}")
    public ResponseEntity<UsuarioResponseDto> editarSenha(@PathVariable Long id,
                                                          @Valid @RequestBody SenhaUpdateRequestDto dto) {
        Usuario user = usuarioService.editarSenha(id, dto);
        return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }
    @PatchMapping("/editarDataNascimento/{id}")
    public ResponseEntity<UsuarioResponseDto> editarDataNascimento(@PathVariable Long id,
                                                                   @Valid @RequestBody DataNascimentoUpdateRequestDto dto) {
        Usuario user = usuarioService.editarDataNascimento(id, dto);
        return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }
}
