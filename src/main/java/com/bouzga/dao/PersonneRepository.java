package com.bouzga.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bouzga.entity.Personne;

@RepositoryRestResource
public interface PersonneRepository extends JpaRepository<Personne, Long>{

}
