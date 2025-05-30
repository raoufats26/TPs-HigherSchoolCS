package org.isi.tpspring.entities.projections;


import org.isi.tpspring.entities.Etudiant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "pr",types = {Etudiant.class})
public interface EtudiantProjection {
    @Value("#{target.name}")
    public String getName();
    @Value("#{target.formation.nom}")
    public String getNomFormation();
}
