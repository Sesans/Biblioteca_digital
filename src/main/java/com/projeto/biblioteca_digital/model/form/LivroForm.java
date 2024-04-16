package com.projeto.biblioteca_digital.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroForm {

    private String nome;

    private String descricao;

    private float valor;
}
