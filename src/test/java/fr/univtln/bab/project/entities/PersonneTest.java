package fr.univtln.bab.project.entities;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

class PersonneTest {
    Joueur joueur1= Joueur.builder()
            .nom("ben")
            .prenom("anass")
            .numero(1)
            .adresse(Adresse.builder()
                    .rue("rue 1")
                    .ville("ville1")
                    .codePostal(83)
                    .pays("france").build())
            .build();

    Joueur joueur2= Joueur.builder()
            .nom("ben")
            .prenom("anass")
            .numero(1)
            .build();

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void getPrenom() {
        Assert.assertThat(joueur1.getPrenom(),is("ben"));
    }

    @Test
    void getNom() {
    }
}