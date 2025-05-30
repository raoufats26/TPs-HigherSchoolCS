package org.isi.msscolarite;


import org.isi.msscolarite.entities.Etablissement;
import org.isi.msscolarite.entities.Etudiant;
import org.isi.msscolarite.entities.repositories.EtablissementRep;
import org.isi.msscolarite.entities.repositories.EtudiantRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.sql.Date;

@SpringBootApplication
@EnableFeignClients
public class MsScolariteApplication implements CommandLineRunner {
    @Autowired
    EtablissementRep etablissementRep;
    @Autowired
    EtudiantRep etudiantRep;


    public static void main(String[] args) {
        SpringApplication.run(MsScolariteApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Etablissement e1 = etablissementRep.save(new Etablissement(null,
                "Esi-Sba", null));
        Etablissement e2 = etablissementRep.save(new Etablissement(null,
                "UDL-Sba", null));
        etudiantRep.save(new Etudiant(null, "ali", Date.valueOf("2000-01-12"), "4isi", null, e1, 1L, null));
        etudiantRep.save(new Etudiant(null, "ahmed", Date.valueOf("2001-01-12"), "5isi", null, e1, 2L, null));
        etudiantRep.save(new Etudiant(null, "akram", Date.valueOf("2002-01-12"), "L3", null, e2, 3L, null));
        etudiantRep.save(new Etudiant(null, "amar", Date.valueOf("2003-01-12"), "L2", null, e2, 3L, null));

    }
}