package br.anhembi.spring01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.spring01.model.User;



@RestController 
@RequestMapping("/user")
public class UserController {
    
    @GetMapping
    public User getMethodName() {
        User user = new User();
        user.setNome("Emerson");
        user.setEmail("emerson@paduan.pro.br");

        return user;
    }

    @PostMapping
    public User postMethodName(@RequestBody User user) {
        User newUser = new User();
        newUser.setNome(user.getNome());
        newUser.setEmail(user.getEmail());
        
        return newUser;
    }
    
}
