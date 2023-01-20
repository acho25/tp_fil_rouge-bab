package fr.univtln.bab.project;

import fr.univtln.bab.project.daos.EquipeDAO;
import fr.univtln.bab.project.entities.*;
import fr.univtln.bab.project.services.EquipeBean;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EquipeBeanTest {

    @Mock
    private EquipeDAO daoMock;

    @InjectMocks
    private EquipeBean bean;

    private Equipe equipe;
    private Equipe equipe2;

    private Validator validator;


    @Before
    public void setUp(){
        equipe = Equipe.builder().nomEquipe("equipe1").build();
        equipe2 = Equipe.builder().nomEquipe("equipe2").build();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testGetEquipe(){
        when(daoMock.find(1)).thenReturn(equipe);
        Equipe result = bean.getEquipe(1);
        assertEquals("resultat doit etre: " + equipe, equipe, result);
    }

    @Test
    public void testAjouterEquipe(){
        bean.ajouterEquipe(equipe);
        verify(daoMock).persist(equipe);
    }

    @Test
    public void testValidation() {
        Equipe equipe = Equipe.builder().nomEquipe("nomEquipe").build();
        Set<ConstraintViolation<Equipe>> violations = validator.validate(equipe);
        assertEquals(1, violations.size());
    }
}


