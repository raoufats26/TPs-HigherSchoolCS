package org.isi.msscolarite.Controller;


import org.isi.msscolarite.Model.Formation;
import org.isi.msscolarite.entities.Etudiant;
import org.isi.msscolarite.proxy.FormationProxy;
import org.isi.msscolarite.entities.repositories.EtudiantRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ScolariteAPI {

    @Autowired
    EtudiantRep etudiantRep;
    @Autowired
    FormationProxy formationProxy;

    @GetMapping("etudiant/{id}")
    public Etudiant getEtudiantWithFormation(@PathVariable("id") Long ide)
    {
        Etudiant e = etudiantRep.findById(ide).get();
        Formation f = formationProxy.getFormation(e.getIdFormation());
        e.setFormation(f);
        return e;
    }
}
