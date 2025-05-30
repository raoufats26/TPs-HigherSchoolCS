package org.isi.msformation.Controller;

import org.isi.msformation.Proxy.EtudiantProxy;
import org.isi.msformation.entities.Formation;
import org.isi.msformation.entities.repositories.FormationRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.ArrayList;

@EnableFeignClients
@RestController
@RequestMapping("/api")
public class  FormationApi {
    @Autowired
    FormationRep formationRep;
    @Autowired
    EtudiantProxy etudiantProxy;

    @GetMapping("/formation/{id}")
    Formation getFormationWithEtudiant(@PathVariable("id")Long id){
        Formation f = formationRep.findById(id).get();
        //f.setEtudiant(etudiantProxy.getEtudiant(id,"toFormation"));
        //f.setEtudiant(new ArrayList<>(etudiantProxy.getEtudiant(id,"toFormation").getContent()));
        f.setEtudiant(new ArrayList<>(
                etudiantProxy.getEtudiant(id,"projectiontoformation").getContent()
        ));
        return f;
    }
}