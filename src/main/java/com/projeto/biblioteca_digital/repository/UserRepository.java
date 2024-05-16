package com.projeto.biblioteca_digital.repository;

import com.projeto.biblioteca_digital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT e FROM User e WHERE e.email LIKE :email")
    Optional<User> findByEmail(@Param("email") String email);

    Boolean existsByCpf(String cpf);

    @Query("SELECT u FROM User u JOIN u.borrowedBooks b WHERE b.id = :bookId")
    List<User> findByBorrowedBook(@Param("bookId") Long bookId);
}
