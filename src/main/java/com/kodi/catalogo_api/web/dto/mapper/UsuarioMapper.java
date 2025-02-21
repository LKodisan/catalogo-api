package com.kodi.catalogo_api.web.dto.mapper;

import com.kodi.catalogo_api.web.dto.UsuarioCreateRequestDto;
import com.kodi.catalogo_api.web.dto.UsuarioResponseDto;
import com.kodi.catalogo_api.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    public static Usuario toUsuario(UsuarioCreateRequestDto requestDto) {
        return new ModelMapper().map(requestDto, Usuario.class);
    }

    public static UsuarioResponseDto toDto(Usuario usuario) {
        ModelMapper mapperMain = new ModelMapper();
        TypeMap<Usuario, UsuarioResponseDto> propertyMapper = mapperMain.createTypeMap(Usuario.class, UsuarioResponseDto.class);
        return mapperMain.map(usuario, UsuarioResponseDto.class);
    }

    public static List<UsuarioResponseDto> toListDto(List<Usuario> usuario) {
        return usuario.stream().map(
                 user -> toDto(user)
        ).collect(Collectors.toList());
    }
}
