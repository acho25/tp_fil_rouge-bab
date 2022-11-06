package fr.univtln.bab.project;



import fr.univtln.bab.project.daos.PersonneDAO;
import fr.univtln.bab.project.personne.Personne;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Hello world!
 *
 */
public class App
{

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




    public static void main( String[] args ) throws IOException {



        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("bab");
        EntityManager em = emf.createEntityManager();

        PersonneDAO p = new PersonneDAO();



        EntityTransaction transac = em.getTransaction();
        transac.begin();


        Personne p1 = new Personne("jajaja");

        em.persist(p1);

        transac.commit();



        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();

    }
}
