package module;

import java.sql.Timestamp;

public class Sighting {
    private int animalId;
    private String location;
    private String rangerName;
    private Timestamp lastSeen;

    public Sighting (int animalId, String location, String rangerName){
        this.animalId = animalId;
        this.location = location;
        this.rangerName = rangerName;
    }

    public int getAnimalId() {
        return animalId;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public Timestamp getLastSeen() {
        return lastSeen;
    }

    @Override
    public boolean equals(Object otherSighting){
        if (!(otherSighting instanceof Sighting)) {
            return false;
        } else {
            Sighting newSighting = (Sighting) otherSighting;
            return this.getLocation().equals(newSighting.getLocation()) &&
                    this.getRangerName().equals(newSighting.getRangerName()) &&
                    this.getAnimalId() == newSighting.getAnimalId();
        }
    }
}
