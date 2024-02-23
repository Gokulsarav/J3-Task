package com.example.Login.Loginrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Login.Logindomain.Login;

@Repository
public interface Logininterface extends JpaRepository<Login, Long>{
    Login findByUsernameAndPassword(String username, String password);
}
