package com.kodi.catalogo_api.service;

import com.kodi.catalogo_api.entity.Usuario;
import com.kodi.catalogo_api.exception.CpfUniqueViolationException;
import com.kodi.catalogo_api.exception.DateTimeInvalidException;
import com.kodi.catalogo_api.exception.EntityNotFoundException;
import com.kodi.catalogo_api.exception.PasswordInvalidException;
import com.kodi.catalogo_api.repository.UsuarioRepository;
import com.kodi.catalogo_api.web.dto.DataNascimentoUpdateRequestDto;
import com.kodi.catalogo_api.web.dto.SenhaUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.RuntimeErrorException;
import java.time.LocalDate;
import java.util.List;

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

    @Transactional(readOnly = true)
    public Usuario listarUsuario(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuário não encontrado.", id))
        );
    }

    @Transactional(readOnly = true)
    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepository.findAll().stream().toList();
    }

    @Transactional
    public Usuario editarSenha(Long id, SenhaUpdateRequestDto dto) {

        Usuario user = listarUsuario(id);

        if (!user.getSenha().equals(dto.getSenhaAtual())) {
            throw new PasswordInvalidException(String.format("Sua senha não confere."));
        }
        if (!dto.getNovaSenha().equals(dto.getConfirmaSenha())) {
            throw new PasswordInvalidException(String.format("Nova senha não confere com confirmação de senha."));
        }

        user.setSenha(dto.getNovaSenha());
        return user;
    }

    @Transactional
    public Usuario editarDataNascimento(Long id, DataNascimentoUpdateRequestDto dto) {

        Usuario user = listarUsuario(id);

        if (dto.getDataNascimento().isAfter(LocalDate.now())) {
            throw new DateTimeInvalidException("Data de Nascimento não pode ser superior a data de hoje.");
        }

        user.setDataNascimento(dto.getDataNascimento());
        return user;

    }
}
