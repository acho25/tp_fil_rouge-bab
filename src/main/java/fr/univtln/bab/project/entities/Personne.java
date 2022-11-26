package fr.univtln.bab.project.entities;


import com.fasterxml.jackson.annotation.JsonIdentityReference;
import fr.univtln.bab.project.annotations.CaseMode;
import fr.univtln.bab.project.annotations.CheckCase;
import fr.univtln.bab.project.annotations.PersonneValidation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

/**
 * Classe mere qui représente une personne avec ses informations principales
 */

@PersonneValidation
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "personne_type")
@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Personne extends Entite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Setter
    String prenom;
    //@CheckCase(CaseMode.UPPER)
    @Setter
    String nom;

    @Column(name = "personne_type"/*, insertable = true, updatable = false*/)
    private String personne_type;

    //@Valid
    @Setter
    @JsonIdentityReference(alwaysAsId = true)
    @OneToOne(mappedBy = "personne", cascade = {CascadeType.ALL})
    Adresse adresse;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personne personne)) return false;
        return Objects.equals(getPrenom(), personne.getPrenom()) && Objects.equals(getNom(), personne.getNom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrenom(), getNom());
    }


}
