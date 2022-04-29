package br.anhembi.spring01.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // indica que esta classe é um controller REST
@RequestMapping("/hello") // indica o nome do "recurso"
public class Hello {
    
    @GetMapping  // indica que será chamado por um GET
    public ResponseEntity<String> digaOla() {
        // return ResponseEntity.ok("Olá mundo!"); // ok = 200
        return ResponseEntity.status(HttpStatus.CREATED).body("Olá mundo!"); // ok = 200
    }

    @GetMapping("/noite/{nome}")
    public ResponseEntity<String> digaOla2(@PathVariable String nome) {
        if(nome.equals("Emerson")){
            return ResponseEntity.ok("Boa noite " + nome + "!");
        }
        return ResponseEntity.notFound().build(); // notFound = 404 
    }

}
