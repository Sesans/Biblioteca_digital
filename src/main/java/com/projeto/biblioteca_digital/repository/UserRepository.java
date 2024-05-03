package com.projeto.biblioteca_digital.repository;

import com.projeto.biblioteca_digital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT e FROM User e WHERE e.email LIKE :email")
    User findByEmail(@Param("email") String email);

    Boolean existsByCpf(String cpf);
}
