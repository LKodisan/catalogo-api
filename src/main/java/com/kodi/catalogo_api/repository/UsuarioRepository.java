package com.kodi.catalogo_api.repository;

import com.kodi.catalogo_api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
