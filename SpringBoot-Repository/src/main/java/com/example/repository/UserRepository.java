package com.example.repository;

import com.example.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;


public interface UserRepository  extends CrudRepository<User, Integer> {

    void delete(User user);

    List findAll();

    User findById(int id);

    User save(User user);
}
