package org.isi.msformation.Proxy;

import org.isi.msformation.Model.Etudiant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "msscolarite", url = "http://localhost:8081")
public interface EtudiantProxy {
    @GetMapping("/etudiants/search/findByIdFormation")
    CollectionModel<Etudiant> getEtudiant(@RequestParam("idf") Long idf,
                                          @RequestParam("projection") String projection);
}
