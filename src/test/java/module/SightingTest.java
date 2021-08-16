package module;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    public Sighting setupSighting(){
        return new Sighting(1,"zone A","Alpha");
    }
    @Test
    public void sighting_instantiatesCorrectly_true(){
        Sighting animal = setupSighting();
        assertEquals(true,animal instanceof Sighting);
    }

}