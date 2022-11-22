package fr.univtln.bab.project.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @Min(200)
    @Setter
    int nbrSpectateurs;
    @NotNull
    @Setter
    Date date;

    @Valid
    @NotNull
    @Size(max = 4)
    @Setter
    @ToString.Exclude
    @OneToMany(mappedBy = "match", cascade = {CascadeType.ALL})
    List<Arbitre> arbitres;

    @Valid
    @NotNull
    @Size(max = 2)
    @Setter
    @ToString.Exclude
    @OneToMany(mappedBy = "match", cascade = {CascadeType.ALL})
    List<Equipe> equipes;

    @Valid
    @NotNull
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
