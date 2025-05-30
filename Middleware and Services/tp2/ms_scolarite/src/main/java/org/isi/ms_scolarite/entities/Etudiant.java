package org.isi.ms_scolarite.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.isi.ms_scolarite.Model.Formation;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

    @Column(nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    private Date dateN;

    @Temporal(TemporalType.DATE)
    private Date dateInscription;

    @Column(nullable = false)
    private String promo;

    @JsonIgnore
    @ManyToOne
    private Etablissement etablissement;
    private Long idFormation;

    @Transient
    private Formation formation;

}