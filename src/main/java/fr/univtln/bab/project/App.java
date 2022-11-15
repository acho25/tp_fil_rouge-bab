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


        Joueur joueur1= Joueur.builder()
                .nom("ben")
                .prenom("anass")
                .numero(1)
                .adresse(Adresse.builder()
                        .rue("rue 1")
                        .ville("ville1")
                        .codePostal(83)
                        .pays("france").build()).build();


        Arbitre arbitre1 = Arbitre.builder()
                .nom("achour")
                .prenom("youness")
                .poste("principale")
                .build();

        Entraineur entraineur1 = Entraineur.builder()
                .nom("boulaghla")
                .prenom("abderrazzak")
                .build();

        List<Joueur> joueurs = new ArrayList<>();
        joueurs.add(joueur1);
        List<Arbitre> arbitres = new ArrayList<>();
        arbitres.add(arbitre1);

        Equipe equipe = Equipe.builder().nomEquipe("psg")
                .entraineur(entraineur1)
                .joueurs(joueurs)
                .match(Match.builder()
                        .joueurs(joueurs)
                        .date(Date.from(Instant.now()))
                        .nbrSpectateurs(100)
                        .arbitres(arbitres)
                        .build())
                .build();




        But but = But.builder()
                .joueur(joueur1)
                .build();


        em.persist(joueur1);
        em.persist(entraineur1);
        em.persist(arbitre1);
        em.persist(equipe);
        em.persist(but);
        transac.commit();


        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.shutdown();

    }
}