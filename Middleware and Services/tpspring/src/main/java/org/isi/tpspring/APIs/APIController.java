package org.isi.tpspring.APIs;
import java.util.List;
import org.isi.tpspring.entities.Etudiant;
import org.isi.tpspring.entities.repositories.EtudiantRep;
import org.isi.tpspring.entities.repositories.FormationRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired
    FormationRep formationRep;
    @Autowired
    EtudiantRep etudiantRep;

    //http://localhost:8081/api/etudiant/all
    @GetMapping("/etudiant/all")
    public List<Etudiant> getEtudiant(){
        return etudiantRep.findAll();
    }

    @GetMapping("/etudiant/{id}")
    public Etudiant getEtudiantById(@PathVariable("id") Long id) {
        return etudiantRep.findById(id).get();
    }

    @PostMapping("/etudiant/add")
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant, @RequestParam("idf") Long idf) {
        etudiant.setFormation(formationRep.findById(idf).get());
        return etudiantRep.save(etudiant);
    }

}
