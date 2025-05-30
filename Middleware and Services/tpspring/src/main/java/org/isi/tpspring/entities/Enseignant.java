package org.isi.tpspring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnseignant;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String specialite;

    @ManyToMany
    @JoinTable(
            name = "enseignant_etudiant",
            joinColumns = @JoinColumn(name = "idEnseignant"),
            inverseJoinColumns = @JoinColumn(name = "idEtudiant")
    )
    @ToString.Exclude
    private List<Etudiant> etudiants;

}
