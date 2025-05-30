package org.isi.ms_scolarite.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "projectiontoformation", types = {Etudiant.class})
public interface EtudProj {
    @Value("#{target.name}")
    public String getNameEtudiant();

    @Value("#{target.etablissement.name}")
    public String getNameEtablissement();
}
