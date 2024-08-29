package com.example.laboratorioapi.service;
import com.example.laboratorioapi.model.User;
import com.example.laboratorioapi.repository.UserRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

     @Autowired
    private UserRepository userRepository;

    //lista todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //lista los usuarios segun por el id que le proporcionemos
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    //crea un ussuario 
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // actualiza el usuario
    public User updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setRole(userDetails.getRole());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User no sububido"));// <= si se muestra una exepcion muestra el mensaje
    }
// borra el usuario dependiendo de el id
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
}
