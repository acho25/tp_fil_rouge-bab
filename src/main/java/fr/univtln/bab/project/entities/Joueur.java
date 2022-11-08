package fr.univtln.bab.project.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table
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

    public Joueur(int numero, String postion, Equipe equipe, List<But> buts, List<Match> matches) {
        this.numero = numero;
        this.postion = postion;
        this.equipe = equipe;
        this.buts = buts;
        this.matches = matches;
    }

    public Joueur() {
    }
}
