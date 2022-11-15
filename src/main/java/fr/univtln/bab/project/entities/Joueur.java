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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@DiscriminatorValue("J")
@ToString
@Entity
@Table(name = "Joueur", uniqueConstraints = {@UniqueConstraint(name = "uniqueJoueur",columnNames = {"numero"})})
public class Joueur extends Personne{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Setter
    int numero;
    @Setter
    String postion;
    @Setter
    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "EQUIPE_ID")
    Equipe equipe;
    @Setter
    @ToString.Exclude
    @OneToMany(mappedBy = "joueur", cascade = {CascadeType.ALL})
    List<But> buts;
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
