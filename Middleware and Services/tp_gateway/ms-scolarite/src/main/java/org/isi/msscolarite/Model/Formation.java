package org.isi.msscolarite.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Formation {
    private Long idFormation;
    private String nom;
    private int duree;
}