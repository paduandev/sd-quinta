package br.anhembi.spring01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.spring01.model.Car;
import br.anhembi.spring01.repository.CarRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarRepo repo;

    @GetMapping("/{id}")
    public ResponseEntity<Car> buscaPorId(@PathVariable long id) {
        Car car = repo.findById(id).orElse(null);

        if (car != null) {
            return ResponseEntity.ok(car);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/placa/{placa}")
    public ResponseEntity<Car> buscaPorPlaca(@PathVariable String placa) {
        Car car = repo.findByPlaca(placa);

        if (car != null) {
            return ResponseEntity.ok(car);
        }
        return ResponseEntity.notFound().build();
    }

}
