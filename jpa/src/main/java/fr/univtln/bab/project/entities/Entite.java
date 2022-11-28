package fr.univtln.bab.project.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
public class Entite {
    /**
     * Interface pour récupérer l'id d'une classe
     */
    public interface Entitee {
        long getId();
    }
}
