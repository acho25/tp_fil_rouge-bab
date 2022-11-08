package fr.univtln.bab.project.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

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

}
