package com.uniovi.repositories;

import com.uniovi.entities.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long>{
	User findByDni(String dni);
	
	@Query("SELECT u FROM User u WHERE (LOWER(u.name) LIKE LOWER(?1) OR LOWER(u.lastName) LIKE LOWER(?1))")
	Page<User> searchByNameOrSurname(Pageable pageable, String searchtext);

	Page<User> findAll(Pageable pageable);

}
