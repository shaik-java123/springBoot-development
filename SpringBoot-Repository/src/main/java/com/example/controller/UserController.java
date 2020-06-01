package com.example.controller;

import com.example.errorHandling.UserException;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

 @GetMapping(path = {"/{id}"})
    public User findOne(@PathVariable("id") int id){

     User user;
     user = userService.findById(id);
         if (user==null) {
             throw new UserException("User Not fount having ID " + id);
         }
         return  user;
 }


    @PutMapping(path = {"/{id}"})
    public User update(@RequestBody User user ,@PathVariable("id") int id){
        return userService.update(user ,id);
    }

    @DeleteMapping(path ={"/{id}"})
    public void delete(@PathVariable("id") int id) {
         userService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){

        List<User> users;
        try {
            users = userService.findAll();
        } catch (UserException ex) {
            return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
