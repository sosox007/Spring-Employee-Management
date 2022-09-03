package com.giantlink.grh.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.giantlink.grh.entities.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>{
	Optional<Team> findByName(String name);
}
