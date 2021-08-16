package module;

import org.sql2o.Connection;

import java.util.List;

public class Animal extends Wildlife implements DatabaseManagement{
    public static final String ANIMAL_TYPE = "animal";

    public Animal(String name){
        this.name = name;
        this.type = ANIMAL_TYPE;
    }

    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof Animal)) {
            return false;
        } else {
            Animal newAnimal = (Animal) otherAnimal;
            return this.getName().equals(newAnimal.getName());
        }
    }

    public static List<Animal> all() {
        String sql = "SELECT * FROM animals WHERE type='animal';";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animal.class);
        }
    }

}
