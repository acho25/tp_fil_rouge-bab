package fr.univtln.bab.project.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Objects;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "Equipe", uniqueConstraints = {@UniqueConstraint(name = "uniqueEquipe", columnNames = {"nomEquipe", "entraineur_id",
})})
public class Equipe extends Entite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Setter
    String nomEquipe;
    @Setter
    @JsonIdentityReference(alwaysAsId = true)
    @OneToOne
    @JoinColumn(name = "ENTRAINEUR_ID", referencedColumnName = "ID")
    Entraineur entraineur;
    @Setter
    @ToString.Exclude
    @OneToMany(mappedBy = "equipe", cascade = {CascadeType.ALL})
    List<Joueur> joueurs;
    @Setter
    @ManyToOne(cascade = {CascadeType.ALL})
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "MATCH_ID")
    Match match;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipe equipe)) return false;
        return getNomEquipe().equals(equipe.getNomEquipe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNomEquipe());
    }
}
