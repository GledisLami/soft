package com.ing.Soft.services;

import com.ing.Soft.entities.User;
import com.ing.Soft.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

}
