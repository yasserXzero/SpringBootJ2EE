package com.example.g_vente.service;


import com.example.g_vente.entity.Users;
import com.example.g_vente.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean verifyUser(String login, String rawPassword) {
        Users user = usersRepository.findByLogin(login);

        if (user == null) {
            return false;
        }

        return passwordEncoder.matches(rawPassword, user.getPass());
    }
}
