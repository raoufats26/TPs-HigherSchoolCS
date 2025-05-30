package org.isi.tpspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;

import java.beans.Transient;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Formation {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormation;

    @Column(nullable = false)
    private String nom;

    @Lob
    private byte[] program;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "formation")
    private List<Etudiant> lesEtudiants;

}
