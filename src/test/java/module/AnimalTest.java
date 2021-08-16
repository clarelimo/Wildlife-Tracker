package module;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @Test
    public void animal_instantiatesCorrectly_true(){
        Animal animal = new Animal("elephant","weak","young");
        assertEquals(true,animal instanceof Animal);
    }

}