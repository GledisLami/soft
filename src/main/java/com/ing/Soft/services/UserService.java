package com.ing.Soft.services;

import com.ing.Soft.entities.Course;
import com.ing.Soft.entities.User;
import com.ing.Soft.repositories.CourseRepository;
import com.ing.Soft.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//a method that saves users

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void saveUser(User user){
        userRepository.save(user);
    }





}