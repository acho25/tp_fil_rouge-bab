package fr.univtln.bab.project.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    @JoinColumn(name = "MATCH_ID")
    Match match;

}
