package fr.univtln.bab.project.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "But", uniqueConstraints = {@UniqueConstraint(name = "uniqueBut",columnNames = ("joueur_id"))})
public class But extends Entite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Setter
    String style;
    @Setter
    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "JOUEUR_ID")
    Joueur joueur;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof But but)) return false;
        return getStyle().equals(but.getStyle()) && getJoueur().equals(but.getJoueur());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStyle(), getJoueur());
    }
}
