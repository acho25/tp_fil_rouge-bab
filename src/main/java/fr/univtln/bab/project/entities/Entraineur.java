package fr.univtln.bab.project.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table
public class Entraineur extends Personne{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Setter
    int nbrDeCoups;

    @Setter
    @JsonIdentityReference(alwaysAsId = true)
    @OneToOne(mappedBy = "entraineur")
    Equipe equipe;

    public Entraineur(String prenom, String nom, Adresse adresse, int nbrDeCoups, Equipe equipe) {
        super(prenom, nom, adresse);
        this.nbrDeCoups = nbrDeCoups;
        this.equipe = equipe;
    }

    public Entraineur() {
    }
}
