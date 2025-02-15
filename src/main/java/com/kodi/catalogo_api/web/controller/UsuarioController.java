package com.kodi.catalogo_api.web.controller;


import com.kodi.catalogo_api.web.dto.UsuarioRequestDto;
import com.kodi.catalogo_api.web.dto.UsuarioResponseDto;
import com.kodi.catalogo_api.web.dto.mapper.UsuarioMapper;
import com.kodi.catalogo_api.entity.Usuario;
import com.kodi.catalogo_api.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/incluir")
    public ResponseEntity<UsuarioResponseDto> criarUsuario(@Valid @RequestBody UsuarioRequestDto dto) {
        Usuario user = usuarioService.criarUsuario(UsuarioMapper.toUsuario(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<UsuarioResponseDto> listarUsuario(@PathVariable Long id){
        Usuario user = usuarioService.listarUsuario(id);
        return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }
}
