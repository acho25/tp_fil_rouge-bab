package fr.univtln.bab.project.resources;

import fr.univtln.bab.project.entities.Match;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MatchResourceTest {
    /**
     * Method under test: {@link MatchResource#creatmatch(Match)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatmatch() {
        // TODO: Complete this test.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of MatchResource.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        // Arrange
        // TODO: Populate arranged inputs
        MatchResource matchResource = null;
        Match a1 = null;

        // Act
        matchResource.creatmatch(a1);

        // Assert
        // TODO: Add assertions on result
    }
}

