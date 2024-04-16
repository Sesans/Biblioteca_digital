package com.projeto.biblioteca_digital.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_livro")
public class Livro {
    @Id
    private Long id;

    private String nome;

    private String descricao;

    private float valor;
}
