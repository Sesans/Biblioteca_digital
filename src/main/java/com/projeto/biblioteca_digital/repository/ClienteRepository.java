package com.projeto.biblioteca_digital.repository;

import com.projeto.biblioteca_digital.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
