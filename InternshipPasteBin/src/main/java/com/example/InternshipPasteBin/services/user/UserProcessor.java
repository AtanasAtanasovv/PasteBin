package com.example.InternshipPasteBin.services.user;

import com.example.InternshipPasteBin.models.User;
import com.example.InternshipPasteBin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserProcessor {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findById(Long id) {
        return userRepository.getById(id);
    }
    public User create(final User user) {
        return userRepository.saveAndFlush(user);
    }
    public User put(Long id, User newUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFullName(newUser.getFullName());
                    user.setPassword(newUser.getPassword());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    return userRepository.save(newUser);
                });
    }
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
