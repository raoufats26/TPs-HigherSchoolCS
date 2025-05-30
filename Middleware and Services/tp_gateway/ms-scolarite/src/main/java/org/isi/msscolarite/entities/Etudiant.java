package org.isi.msscolarite.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.isi.msscolarite.Model.Formation;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

    private String nom;

    @Temporal(TemporalType.DATE)
    private Date dateN;

    private String promo;

    @Temporal(TemporalType.DATE)
    private Date dateInscription;

    @ManyToOne
    private Etablissement etablissement;

    private Long idFormation;
    @Transient
    private Formation formation;
}