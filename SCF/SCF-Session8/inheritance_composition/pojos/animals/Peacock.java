package inheritance_composition.pojos.animals;

import inheritance_composition.pojos.animal_type.Bird;

public class Peacock extends Bird {
    
    public Peacock(String name, int age, String sound, int flight) {
        super(name, age, sound, flight);
    }

}
