package br.anhembi.spring01.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.spring01.model.User;

//CRUD = Create, Read, Update, Delete
public interface UserRepo extends CrudRepository <User, Long> {
    
}
