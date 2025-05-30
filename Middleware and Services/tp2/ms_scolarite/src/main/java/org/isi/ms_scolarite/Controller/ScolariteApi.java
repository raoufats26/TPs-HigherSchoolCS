package org.isi.ms_scolarite.Controller;

import org.isi.ms_scolarite.Model.Formation;
import org.isi.ms_scolarite.entities.Etudiant;
import org.isi.ms_scolarite.entities.repositories.EtablissementRep;
import org.isi.ms_scolarite.entities.repositories.EtudiantRep;
import org.isi.ms_scolarite.proxy.FormationProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class ScolariteApi {

    @Autowired
    EtudiantRep etudiantRep;
    @Autowired
    EtablissementRep etablissementRep;
    @Autowired
    FormationProxy formationProxy;

    @GetMapping("/etudiant/{id}")
    private  Etudiant getEtudiantWithFormation(@PathVariable("id") Long ide) {
        Etudiant e = etudiantRep.findById(ide).get();
        Formation f = formationProxy.getFormation(e.getIdFormation());
        e.setFormation(f);
        return e;
    }


}
