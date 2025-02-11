package com.kodi.catalogo_api.service;

import com.kodi.catalogo_api.entity.Usuario;
import com.kodi.catalogo_api.exception.CpfUniqueViolationException;
import com.kodi.catalogo_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario criarUsuario(Usuario usuario){
        if (!usuario.getDataNascimento().isAfter(LocalDate.now())) {
            try {
                return usuarioRepository.save(usuario);
            } catch (org.springframework.dao.DataIntegrityViolationException ex) {
                throw new CpfUniqueViolationException(String.format("Usuário com Cpf '%s' já cadastrado.", usuario.getCpf()));
            }
        }
        throw new RuntimeException("Não é permitido cadastrar data de nascimento com data futura.");
    }
}
