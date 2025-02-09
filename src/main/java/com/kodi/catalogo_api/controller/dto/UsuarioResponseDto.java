package com.kodi.catalogo_api.controller.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioResponseDto {

    private Long id;
    private String cpf;
    private LocalDate dataNascimento;
}
