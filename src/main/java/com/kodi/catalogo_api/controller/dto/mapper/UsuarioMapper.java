package com.kodi.catalogo_api.controller.dto.mapper;

import com.kodi.catalogo_api.controller.dto.UsuarioRequestDto;
import com.kodi.catalogo_api.controller.dto.UsuarioResponseDto;
import com.kodi.catalogo_api.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

public class UsuarioMapper {

    public static Usuario toUsuario(UsuarioRequestDto requestDto) {
        return new ModelMapper().map(requestDto, Usuario.class);
    }

    public static UsuarioResponseDto toDto(Usuario usuario) {
        ModelMapper mapperMain = new ModelMapper();
        TypeMap<Usuario, UsuarioResponseDto> propertyMapper = mapperMain.createTypeMap(Usuario.class, UsuarioResponseDto.class);
        return mapperMain.map(usuario, UsuarioResponseDto.class);
    }
}
