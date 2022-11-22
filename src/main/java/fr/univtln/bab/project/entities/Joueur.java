package fr.univtln.bab.project.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import fr.univtln.bab.project.annotations.CheckPosition;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

/**
 *Classe fille qui représente un joueur dans une equipe
 */

@Getter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@DiscriminatorValue("J")
@ToString
@Entity
@Table(name = "Joueur", uniqueConstraints = {@UniqueConstraint(name = "uniqueJoueur",columnNames = {"numero","position"})})
public class Joueur extends Personne{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Min(1)
    @Digits(integer = 2,fraction = 0)
    @Setter
    int numero;
    @CheckPosition
    @Setter
    String postion;

    @Valid
    @NotNull
    @Setter
    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "EQUIPE_ID")
    Equipe equipe;

    @Valid
    @NotNull
    @Setter
    @ToString.Exclude
    @OneToMany(mappedBy = "joueur", cascade = {CascadeType.ALL})
    List<But> buts;

    @Valid
    @NotNull
    @Setter
    @ToString.Exclude
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "JOUEUR_MATCH",
            joinColumns = {@JoinColumn(name = "JOUEUR_ID")},
            inverseJoinColumns = {@JoinColumn(name = "MATCH_ID")})
    List<Match> matches;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Joueur joueur)) return false;
        return getNumero() == joueur.getNumero() && Objects.equals(getPostion(), joueur.getPostion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNumero(), getPostion());
    }
}
