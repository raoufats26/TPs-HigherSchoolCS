package org.isi.ms_scolarite.entities.repositories;

import org.isi.ms_scolarite.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRep extends JpaRepository<Etudiant, Long> {
    List<Etudiant> findByIdFormation(Long idF);
}
