package com.projeto.biblioteca_digital.entity.form;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    @NotBlank
    @Size(min = 5, max = 50)
    private String fullName;

    @NotBlank
    //@CPF
    private String cpf;

    @NotBlank
    @Size(min = 4, max = 15)
    private String userName;

    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

    //@CreditCardNumber
    @NotBlank
    private String Card;

    @NotBlank
    @Email
    private String email;
}