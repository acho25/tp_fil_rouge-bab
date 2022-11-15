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
@DiscriminatorValue("A")
@ToString
@Entity
@Table
public class Arbitre extends Personne{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Setter
    String poste;

    @Setter
    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "MATCH_ID")
    Match match;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arbitre arbitre)) return false;
        return  getPoste().equals(arbitre.getPoste()) && Objects.equals(getMatch(), arbitre.getMatch());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoste(), getMatch());
    }
}
