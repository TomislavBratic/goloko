package com.example.goloko.service;

import com.example.goloko.model.User;
import com.example.goloko.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        Optional<User> userOptional = userRepository.findById(id);

        if(userOptional.isPresent()){
            return userOptional.get();
        }
        else{
            throw new RuntimeException();
        }
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
