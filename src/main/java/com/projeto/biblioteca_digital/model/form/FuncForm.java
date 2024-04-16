package com.projeto.biblioteca_digital.model.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FuncForm extends UserForm{
    private String cargo;
    private float salario;
}
