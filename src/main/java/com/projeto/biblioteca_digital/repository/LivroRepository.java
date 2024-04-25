package com.projeto.biblioteca_digital.repository;

import com.projeto.biblioteca_digital.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT l FROM Livro l WHERE l.nome ILIKE %:nome%")
    List<Livro> getLivroBuscandoNome(@Param("nome") String nome);

    @Query("SELECT l FROM Livro l WHERE l.valor <= :valor")
    List<Livro> getLivroBuscandoValor(@Param("valor") double valor);
}
