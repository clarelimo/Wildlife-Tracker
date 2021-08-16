package module;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    public Animal setUpAnimal(){
        return new Animal("elephant");
    }

    @Test
    public void animal_instantiatesCorrectly_true(){
//        Animal animal = new Animal("elephant","weak","young");
        Animal animal = setUpAnimal();
        assertEquals(true,animal instanceof Animal);
    }

    @Test
    public void animal_instantiatesWithName_String(){
        Animal animal = setUpAnimal();
        assertEquals("elephant",animal.getName());
    }

    @Test
    public void equals_returnsTrueIfNameAreSame_true() {
        Animal testAnimal = setUpAnimal();
        Animal anotherAnimal = new Animal("elephant");
        assertTrue(testAnimal.equals(anotherAnimal));
    }

}