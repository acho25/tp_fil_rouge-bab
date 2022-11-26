package fr.univtln.bab.project.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;


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
@Entity
@Table
@ToString
public class Entraineur extends Personne{
    @Setter
    int nbrDeCoups;

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
