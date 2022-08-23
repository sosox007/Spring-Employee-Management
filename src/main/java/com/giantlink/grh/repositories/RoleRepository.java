package com.giantlink.grh.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giantlink.grh.entities.ERole;
import com.giantlink.grh.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByName(ERole role);
}
