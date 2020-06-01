package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(int id) {
         repository.deleteById(id);

    }

    @Override
    public List findAll() {
        return repository.findAll();
    }



    @Override
    public User findById(int id) {
        return repository.findById(id);
    }

    @Override
    public User update(User user , int id) {

        User userObj = repository.findById(id);
        if(userObj!=null) {
            userObj.setEmail(user.getEmail());
            userObj.setFirstName(user.getFirstName());
            userObj.setLastName(user.getLastName());
            return repository.save(userObj);
        }
        else {
            userObj = new User();
            userObj.setFirstName("User Not Exists");
            return userObj;
        }
    }
}