package org.isi.tpspring.entities.repositories;

import org.isi.tpspring.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EnseignantRep extends JpaRepository<Enseignant, Long> {
}
