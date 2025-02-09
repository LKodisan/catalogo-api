package com.kodi.catalogo_api.service;

import com.kodi.catalogo_api.entity.Usuario;
import com.kodi.catalogo_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario criarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
