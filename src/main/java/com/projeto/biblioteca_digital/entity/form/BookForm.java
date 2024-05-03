package com.projeto.biblioteca_digital.entity.form;

import jakarta.validation.constraints.*;
import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.XMLEncoder;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookForm {

    @NotBlank
    @Size(message = "Nome deve ter entre {min} e {max}", min = 3, max = 50)
    private String name;

    @NotBlank
    @Size(message = "Descrição deve ter entre {min} e {max}", min = 3, max = 50)
    private String description;

    @NotNull
    @Positive(message = "Valor deve ser um número positivo")
    private double value;

    @Positive
    @NotBlank(message = "O campo Unidades Disponíveis deve ser preenchido!")
    @Size(min = 1, max = 99, message = "Unidades devem estar entre {min} e {max}")
    private Long unitsAvailable;
}
