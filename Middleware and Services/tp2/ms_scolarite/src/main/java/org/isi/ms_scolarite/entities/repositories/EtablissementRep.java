package org.isi.ms_scolarite.entities.repositories;

import org.isi.ms_scolarite.entities.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtablissementRep extends JpaRepository<Etablissement, Long> {
}
