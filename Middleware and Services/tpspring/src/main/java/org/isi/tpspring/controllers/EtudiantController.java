package org.isi.tpspring.controllers;

import org.isi.tpspring.entities.Etudiant;
import org.isi.tpspring.entities.repositories.EtudiantRep;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    private final EtudiantRep etudiantRep;

    public EtudiantController(EtudiantRep etudiantRep) {
        this.etudiantRep = etudiantRep;
    }

    @GetMapping("/{id}")
    public String getEtudiantById(@PathVariable Long id) {
        return etudiantRep.findEtudiantByIdEtudiant(id);
    }

    @GetMapping("/search/{name}")
    public List<Etudiant> getEtudiantsByName(@PathVariable String name) {
        return etudiantRep.findEtudiantByNameStartingWith(name);
    }


    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantRep.save(etudiant);
    }

    @DeleteMapping("/{id}")
    public String deleteEtudiant(@PathVariable Long id) {
        Optional<Etudiant> etudiant = etudiantRep.findById(id);

        if (etudiant.isPresent()) {
            etudiantRep.delete(etudiant.get()); 
            return "Etudiant with ID " + id + " has been deleted successfully!";
        } else {
            return "Etudiant with ID " + id + " not found!";
        }
    }

    @PutMapping("/{id}")
    public Etudiant updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiantDetails) {
        return etudiantRep.findById(id).map(etudiant -> {
            etudiant.setName(etudiantDetails.getName());
            etudiant.setDateN(etudiantDetails.getDateN());
            etudiant.setAge(etudiantDetails.getAge());
            etudiant.setImage(etudiantDetails.getImage());
            return etudiantRep.save(etudiant);
        }).orElseThrow(() -> new RuntimeException("Etudiant not found with ID: " + id));
    }

    @PatchMapping("/{id}")
    public Etudiant partialUpdateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiantDetails) {
        return etudiantRep.findById(id).map(etudiant -> {
            if (etudiantDetails.getName() != null) etudiant.setName(etudiantDetails.getName());
            if (etudiantDetails.getDateN() != null) etudiant.setDateN(etudiantDetails.getDateN());
            if (etudiantDetails.getAge() != null) etudiant.setAge(etudiantDetails.getAge());
            if (etudiantDetails.getImage() != null) etudiant.setImage(etudiantDetails.getImage());
            return etudiantRep.save(etudiant);
        }).orElseThrow(() -> new RuntimeException("Etudiant not found with ID: " + id));
    }


}
