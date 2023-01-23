package fr.univtln.bab.project;

import fr.univtln.bab.project.daos.PersonneDAO;
import fr.univtln.bab.project.entities.Adresse;
import fr.univtln.bab.project.entities.Joueur;
import fr.univtln.bab.project.entities.Personne;
import fr.univtln.bab.project.services.PersonneBean;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PersonneBeanTest {

    @Mock
    private PersonneDAO personneDAO;

    @InjectMocks
    private PersonneBean personneBean;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInit() {
        personneBean.init();
        assertNotNull(personneBean.getPersonne());
    }

    @Test
    public void testGetPersonne() {
        Personne expected = Joueur.builder().nom("b").prenom("anass").numero(7).postion("DEFENCEUR").adresse(Adresse.builder()
                .rue("rue 1").ville("ville1").codePostal(83).pays("france").build()).build();
        when(personneDAO.find(expected.getId())).thenReturn(expected);
        Personne actual = personneBean.getPersonne(expected.getId());
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPersonnes() {
        List<Personne> expected = Arrays.asList(new Personne(), new Personne());
        when(personneDAO.findAll()).thenReturn(expected);
        List<Personne> actual = personneBean.getPersonnes();
        assertEquals(expected, actual);
    }

    @Test
    public void testAjouterPersonne() {
        Personne personne = new Personne();
        personneBean.ajouterPersonne(personne);
        verify(personneDAO).persist(personne);
    }

    @Test
    public void testModifierPersonne() {
        Personne personne = new Personne();
        personneBean.modifierPersonne(personne);
        verify(personneDAO).update(personne);
    }

}
