package org.isi.tpspring.entities.repositories;
import org.isi.tpspring.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource

public interface FormationRep extends JpaRepository<Formation,Long> {
}
