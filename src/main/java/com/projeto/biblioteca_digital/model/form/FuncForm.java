package com.projeto.biblioteca_digital.model.form;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncForm extends UserForm{
    private String cargo;
    private float salario;
}
