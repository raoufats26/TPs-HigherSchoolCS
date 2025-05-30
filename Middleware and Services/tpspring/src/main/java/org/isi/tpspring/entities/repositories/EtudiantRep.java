package org.isi.tpspring.entities.repositories;
import org.springframework.data.repository.query.Param;
import org.isi.tpspring.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource

public interface EtudiantRep extends JpaRepository<Etudiant,Long> {
//List<Etudiant> findEtudiantByIdEtudiant(Long ide);
List<Etudiant> findEtudiantByNameStartingWith(String nom);

    @Query(value = "SELECT name FROM etudiant WHERE id_etudiant = :ide", nativeQuery = true)
    String findEtudiantByIdEtudiant(@Param("ide") Long ide);
}
