package fr.univtln.bab.project.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 *Classe qui représente un entraineur d'une equipe
 */

@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@DiscriminatorValue("E")
@ToString
@Entity
@Table
public class Entraineur extends Personne{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Setter
    int nbrDeCoups;

    @NotNull
    @Valid
    @Setter
    @JsonIdentityReference(alwaysAsId = true)
    @OneToOne(mappedBy = "entraineur")
    Equipe equipe;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entraineur that)) return false;
        return getEquipe().equals(that.getEquipe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEquipe());
    }
}
