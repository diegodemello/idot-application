package br.com.idot.controller;

import br.com.idot.model.User;
import br.com.idot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public void registerUser(User user){
        userService.registerUser(user);
    }

    @GetMapping("users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
}
