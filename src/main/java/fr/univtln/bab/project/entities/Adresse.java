package fr.univtln.bab.project.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;


import java.util.Objects;

/**
 *Classe qui représente les informations d'une adresse d'une personne
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "Adresse", uniqueConstraints = {@UniqueConstraint(name = "uniqueAdresse",columnNames = ("personne_id"))})
public class Adresse extends Entite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Setter
    String rue;
    @Setter
    String ville;
    @Setter
    int codePostal;
    @Setter
    String pays;

    @Valid
    @NotNull
    @Setter
    @JsonIdentityReference(alwaysAsId = true)
    @OneToOne
    @JoinColumn(name = "PERSONNE_ID",referencedColumnName = "ID")
    Personne personne;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adresse adresse)) return false;
        return Objects.equals(getRue(), adresse.getRue()) && Objects.equals(getVille(),
                adresse.getVille()) && Objects.equals(getPays(), adresse.getPays())
                && Objects.equals(getPersonne(), adresse.getPersonne());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRue(), getVille(), getPays(), getPersonne());
    }
}
