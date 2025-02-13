
package com.example.student.management.system.Service;

import com.example.student.management.system.Model.User;
import com.example.student.management.system.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public User registerUser(User user) {
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encode password
        return repository.save(user);
    }

    public boolean isEmailExists(String email) {
        return repository.findByEmail(email).isPresent();
    }

    public Optional<User> getUserByEmail(String name) {
        return repository.findByEmail(name);
    }
}

