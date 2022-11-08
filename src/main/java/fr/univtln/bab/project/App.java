package fr.univtln.bab.project;


import fr.univtln.bab.project.daos.PersonneDAO;
import fr.univtln.bab.project.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.glassfish.grizzly.http.server.HttpServer;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    public static final String BASE_URI = "http://localhost:8080/myapp/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     *
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in fr.univtln.bruno.demos.jaxrs package
        final ResourceConfig rc = new ResourceConfig().packages("fr.univtln.bab.project");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }


    public static void main(String[] args) throws IOException {


        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("bab");
        EntityManager em = emf.createEntityManager();


        EntityTransaction transac = em.getTransaction();
        transac.begin();


        Personne personne = Joueur.builder().build();
        personne.setNom("Anass");
        personne.setPrenom("Ben");
        Adresse adresse = Adresse.builder().build();
        adresse.setRue("rue 1");
        adresse.setPays("France");
        adresse.setCodePostal(83);
        adresse.setPersonne(personne);
        personne.setAdresse(adresse);

        Personne personne1 = Arbitre.builder().build();
        personne1.setNom("youness");
        personne1.setPrenom("Acho");

        Personne personne2 = Entraineur.builder().build();
        personne2.setNom("abder");
        personne2.setPrenom("Bou");

        Equipe equipe = Equipe.builder().build();
        equipe.setNomEquipe("real");

        List<Joueur> joueurs = new ArrayList<>();
        joueurs.add((Joueur) personne);

        Match match = Match.builder().build();
        match.setJoueurs(joueurs);
        match.setDate(Date.from(Instant.now()));
        match.setNbrSpectateurs(100);
        List<Arbitre> arbitres = new ArrayList<>();
        arbitres.add((Arbitre) personne1);
        match.setArbitres(arbitres);

        equipe.setMatch(match);
        equipe.setEntraineur((Entraineur) personne2);

        But but = But.builder().build();
        but.setJoueur((Joueur) personne);

        equipe.setJoueurs(joueurs);

        List<Match> matches = new ArrayList<>();
        matches.add(match);
        ((Joueur) personne).setMatches(matches);

        em.persist(personne);
        em.persist(personne2);
        em.persist(personne1);
        em.persist(equipe);
        em.persist(match);
        em.persist(but);
        transac.commit();


        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();

    }
}