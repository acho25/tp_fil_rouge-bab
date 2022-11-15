package fr.univtln.bab.project.entities;


import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

import java.util.Objects;



@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="personne_type")
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class Personne extends Entite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Setter
    String prenom;
    @Setter
    String nom;
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
