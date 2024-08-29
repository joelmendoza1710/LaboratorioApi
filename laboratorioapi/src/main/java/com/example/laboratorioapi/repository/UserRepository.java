package com.example.laboratorioapi.repository;
import com.example.laboratorioapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
