package com.kodi.catalogo_api.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioUpdateRequestDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    @NotBlank
    @Size(min = 8, max = 16)
    private String senhaAtual;
    @NotBlank
    @Size(min = 8, max = 16)
    private String novaSenha;
    @NotBlank
    @Size(min = 8, max = 16)
    private String confirmaSenha;
}
