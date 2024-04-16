package com.projeto.biblioteca_digital.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    private Long id;
    private String nome;
    private String cpf;
    private String senha;
}
