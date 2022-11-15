package fr.univtln.bab.project.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class EntraineurTest {
    /**
     * Method under test: {@link Entraineur#equals(Object)}
     */

    @Test
    void testEquals() {
        assertNotEquals(new Entraineur(), null);
        assertNotEquals(new Entraineur(), "Different type to Entraineur");
    }

    /**
     * Method under test: {@link Entraineur#equals(Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testEquals3() {
        Entraineur entraineur1 = Entraineur.builder()
                .nom("boulaghla")
                .prenom("abderrazzak")
                .build();
        assertThrows(NullPointerException.class, () -> entraineur1.equals(new Entraineur()));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Entraineur#equals(Object)}
     *   <li>{@link Entraineur#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        Entraineur entraineur = new Entraineur();
        assertEquals(entraineur, entraineur);
        int expectedHashCodeResult = entraineur.hashCode();
        assertEquals(expectedHashCodeResult, entraineur.hashCode());
    }

    /**
     * Method under test: {@link Entraineur#equals(Object)}
     */
    @Test
    void testEquals4() {
        Entraineur entraineur = new Entraineur();
        entraineur.setEquipe(new Equipe());
        assertNotEquals(entraineur, new Entraineur());
    }
}

