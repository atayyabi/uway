package com.uway.server.repository;

import com.uway.server.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

	User findById(long id);

	User findUserByUsername(String username);
	
	boolean existsByUsername(String username);
	
	
	

}