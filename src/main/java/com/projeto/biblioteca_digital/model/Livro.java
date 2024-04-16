package com.projeto.biblioteca_digital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_livro")
public class Livro {
    @Id
    private Long id;

    private String nome;

    private String descricao;
}
