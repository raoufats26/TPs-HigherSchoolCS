package org.example.msformation.entities.repositories;

import org.example.msformation.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FormationRep extends JpaRepository<Formation,Long> {

}