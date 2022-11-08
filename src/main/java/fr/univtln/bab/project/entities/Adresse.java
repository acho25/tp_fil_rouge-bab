package fr.univtln.bab.project.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @Setter
    @JsonIdentityReference(alwaysAsId = true)
    @OneToOne
    @JoinColumn(name = "PERSONNE_ID",referencedColumnName = "ID")
    Personne personne;

}
