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
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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
        Etablissement e1 = etablissementRep.save(new Etablissement(null,"esi-sba",null));
        Etablissement e2 = etablissementRep.save(new Etablissement(null,"univ-sba",null));
        java.sql.Date birthDate = Date.valueOf("2025-01-01");
        etudiantRep.save(new Etudiant(
                        null,
                        "Ali",
                null,
                "4isi",
                birthDate,
                e1,
                1L,
                null
                ));
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
