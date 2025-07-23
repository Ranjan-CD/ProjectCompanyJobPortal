package com.project.JobApp.service;


import com.project.JobApp.model.User;
import com.project.JobApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

   @Autowired
   private UserRepo userRepo;
    public User saveUser(User user){
        return userRepo.save(user);
    }
}
