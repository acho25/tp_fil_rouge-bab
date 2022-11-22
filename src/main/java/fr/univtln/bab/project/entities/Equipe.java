package fr.univtln.bab.project.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import fr.univtln.bab.project.annotations.CaseMode;
import fr.univtln.bab.project.annotations.CheckCase;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;


import java.util.List;
import java.util.Objects;

/**
 *Classe qui représente une equipe de joueurs avec un entraineur
 */

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
    @NotNull
    @CheckCase(CaseMode.UPPER)
    @Setter
    String nomEquipe;

    @Valid
    @NotNull
    @Setter
    @JsonIdentityReference(alwaysAsId = true)
    @OneToOne
    @JoinColumn(name = "ENTRAINEUR_ID", referencedColumnName = "ID")
    Entraineur entraineur;

    @Valid
    @NotNull
    @Size(max = 14)
    @Setter
    @ToString.Exclude
    @OneToMany(mappedBy = "equipe", cascade = {CascadeType.ALL})
    List<Joueur> joueurs;

    @Valid
    @NotNull
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
