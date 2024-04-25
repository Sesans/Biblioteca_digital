package com.projeto.biblioteca_digital.entity.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroForm {

    @NotBlank
    @Size(message = "Nome deve ter entre {min} e {max}", min = 3, max = 50)
    private String nome;

    @NotBlank
    @Size(message = "Descrição deve ter entre {min} e {max}", min = 3, max = 50)
    private String descricao;

    @Positive
    @NotEmpty
    private double valor;
}
