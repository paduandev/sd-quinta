package br.anhembi.spring01.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.spring01.model.Car;

public interface CarRepo extends CrudRepository<Car, Long> {
    Car findByPlaca(String placa);
}
