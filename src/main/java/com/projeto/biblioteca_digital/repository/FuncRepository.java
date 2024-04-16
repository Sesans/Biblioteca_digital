package com.projeto.biblioteca_digital.repository;

import com.projeto.biblioteca_digital.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncRepository extends JpaRepository<Funcionario, Long> {

}
