package org.isi.tpspring.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @Transient()
    private Integer age;

    @Lob
    private byte[] image;

    @ManyToOne
    @JoinColumn(name="idFormation")
    private Formation formation;

    @ManyToMany(mappedBy = "etudiants")
    private List<Enseignant> enseignants;


}
