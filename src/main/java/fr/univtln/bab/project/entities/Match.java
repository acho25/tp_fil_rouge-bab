package fr.univtln.bab.project.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class Match extends Entite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Setter
    int nbrSpectateurs;
    @Setter
    Date date;
    @Setter
    @ToString.Exclude
    @OneToMany(mappedBy = "match", cascade = {CascadeType.ALL})
    List<Arbitre> arbitres;
    @Setter
    @ToString.Exclude
    @OneToMany(mappedBy = "match", cascade = {CascadeType.ALL})
    List<Equipe> equipes;
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
