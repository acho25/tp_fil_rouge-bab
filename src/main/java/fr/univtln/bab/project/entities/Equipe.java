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
public class Equipe extends Entite{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Setter
    String nomEquipe;
    @Setter
    @JsonIdentityReference(alwaysAsId = true)
    @OneToOne(mappedBy = "equipe")
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

    public Equipe(String nomEquipe, Entraineur entraineur, List<Joueur> joueurs) {
        this.nomEquipe = nomEquipe;
        this.entraineur = entraineur;
        this.joueurs = joueurs;
    }

    public Equipe() {
    }
}
