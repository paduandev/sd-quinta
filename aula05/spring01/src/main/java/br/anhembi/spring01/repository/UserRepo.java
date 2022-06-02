package br.anhembi.spring01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.anhembi.spring01.model.User;

//CRUD = Create, Read, Update, Delete
public interface UserRepo extends CrudRepository<User, Long> {
    @Query("select u from User u where u.nome like %?1%")
    List<User> findByNameLike(String name);
}
