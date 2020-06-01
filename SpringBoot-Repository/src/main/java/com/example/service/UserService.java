package com.example.service;

import com.example.model.User;

import java.util.List;

public interface UserService {


    void delete(int id );

    List<User> findAll();

    User findById(int id);

    User update(User user , int id);

    User create(User user);
}
