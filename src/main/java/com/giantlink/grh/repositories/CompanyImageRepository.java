package com.giantlink.grh.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giantlink.grh.entities.CompanyImage;

@Repository
public interface CompanyImageRepository extends JpaRepository<CompanyImage, String> {

}
