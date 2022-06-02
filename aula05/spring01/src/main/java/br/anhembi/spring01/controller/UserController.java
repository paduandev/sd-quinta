package br.anhembi.spring01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.spring01.model.User;
import br.anhembi.spring01.repository.UserRepo;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired // injeção de dependência
    private UserRepo repo;

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User user) {
        User newUser = repo.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> listUser = (List<User>) repo.findAll();

        return ResponseEntity.ok(listUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable long id) {
        User user = repo.findById(id).orElse(null);

        if (user != null) {
            return ResponseEntity.ok(user); // status 200
        }

        return ResponseEntity.notFound().build(); // status 404
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<User>> findByName(@PathVariable String nome) {
        List<User> listaUser = repo.findByNameLike(nome);

        if (listaUser != null) {
            return ResponseEntity.ok(listaUser); // status 200
        }
        return ResponseEntity.notFound().build(); // status 404
    }

    @PutMapping
    public ResponseEntity<User> updateById(@RequestBody User user) {
        User userFound = repo.findById(user.getCode()).orElse(null);

        if (userFound != null) {
            repo.save(user);
            return ResponseEntity.ok(userFound); // status 200
        }

        return ResponseEntity.notFound().build(); // status 404
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        User user = repo.findById(id).orElse(null);

        if (user != null) {
            repo.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.notFound().build(); // status 404
    }

}
