package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.LinkBuilder;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    UserDaoService userDaoService;

    //retrieveAllUsers
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    //retrieveUser(int id)
    @GetMapping("/user/{id}")
    public User retrieveUser(@PathVariable int id){
        User user = userDaoService.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id-"+id);
        }
        return user;
    }

    //create
    //input - details of user
    //output created & return the created uri
    @PostMapping("/users")
    public  ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.save(user);
        //created
        //user/4

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
        User user = userDaoService.deleteById(id);
        if(user == null){
            throw new UserNotFoundException("id-"+id);
        }

    }



}
