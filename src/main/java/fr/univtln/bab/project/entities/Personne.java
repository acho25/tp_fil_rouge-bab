package fr.univtln.bab.project.entities;


import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.persistence.*;


@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="personne_type")
@Entity
@Table
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

}
