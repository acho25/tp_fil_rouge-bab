package fr.univtln.bab.project.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import fr.univtln.bab.project.annotations.CaseMode;
import fr.univtln.bab.project.annotations.CheckCase;
import fr.univtln.bab.project.annotations.CheckPosition;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Objects;

/**
 *Classe fille qui représente un joueur dans une equipe
 */

@Getter
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@DiscriminatorValue("J")
@ToString
@JsonRootName(value = "joueur")
@Entity
@Table(name = "Joueur", uniqueConstraints = {@UniqueConstraint(name = "uniqueJoueur",columnNames = {"numero"})})
public class Joueur extends Personne{

    //@Min(value = 1)
    @Setter
    @JsonProperty("numero")
    int numero;
    //@CheckPosition
    //@CheckCase(CaseMode.UPPER)
    @Setter
    @JsonProperty("position")
    String postion;

    //@Valid
    @Setter
    @ManyToOne
    //@JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "EQUIPE_ID")
    @Getter
    Equipe equipe;

    @Getter
    @Setter
    int equipeId;

    //@Valid
    @Setter
    @ToString.Exclude
    //@JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "joueur", cascade = {CascadeType.ALL})
    List<But> buts;

    //@Valid
    @Setter
    @ToString.Exclude
    //@JsonIdentityReference(alwaysAsId = true)
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
