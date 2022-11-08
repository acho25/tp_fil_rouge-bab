package fr.univtln.bab.project.entities;


import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.persistence.*;


@Getter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table
public class Personne extends Entite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Setter
    String prenom;
    @Setter
    String nom;
    @Setter
    @JsonIdentityReference(alwaysAsId = true)
    @OneToOne(mappedBy = "personne")
    Adresse adresse;

    public Personne(String prenom, String nom, Adresse adresse) {
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
    }

    public Personne() {

    }

}
