package com.example.g_vente.repository;

import com.example.g_vente.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
        Users findByLogin(String login);
}