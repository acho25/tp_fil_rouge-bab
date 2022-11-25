package fr.univtln.bab.project.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *Classe qui représente un match entre deux equipes
 */

@Entity
@Table
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class Match extends Entite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Min(value= 200)
    @Setter
    int nbrSpectateurs;

    @Setter
    Date date;

    @Valid
    @Size(max = 4)
    @Setter
    @ToString.Exclude
    @OneToMany(mappedBy = "match", cascade = {CascadeType.ALL})
    List<Arbitre> arbitres;

    @Valid
    @Size(max = 2)
    @Setter
    @ToString.Exclude
    @OneToMany(mappedBy = "match", cascade = {CascadeType.ALL})
    List<Equipe> equipes;

    @Valid
    @Size(max = 22)
    @Setter
    @ToString.Exclude
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToMany(mappedBy = "matches", cascade = {CascadeType.ALL})
    List<Joueur> joueurs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match match)) return false;
        return Objects.equals(getArbitres(), match.getArbitres()) && Objects.equals(getEquipes(), match.getEquipes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArbitres(), getEquipes());
    }
}
