package com.giantlink.grh.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giantlink.grh.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

}
