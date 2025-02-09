package com.kodi.catalogo_api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor @Getter @Setter
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(name = "cpf",nullable = false,unique = true,length = 11)
    @Size(min = 11, max = 11)
    private String cpf;
    @Size(min = 8, max = 16)
    @Column(name = "senha",nullable = false,length = 16)
    private String senha;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "dataNascimento",nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "DTH_Insert")
    private LocalDateTime dth_Insert;
    @Column(name = "DTH_Update")
    private LocalDateTime dth_Update;
    @Column(name = "DTH_Delete")
    private LocalDateTime dth_Delete;
    @Column(name = "UsuarioId_Insert")
    private String usuarioId_Insert;
    @Column(name = "UsuarioId_Update")
    private String usuarioId_Update;
    @Column(name = "UsuarioId_Delete")
    private String usuarioId_Delete;

}
