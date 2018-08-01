package inheritance_composition.pojos.animals;

import inheritance_composition.implementation.TypeOfAnimal;
import inheritance_composition.pojos.animal_type.Reptile;

public class Crocodile extends Reptile{
    
    public Crocodile(String name, int age, String sound, int legs) {
        super(name, age, sound, legs, TypeOfAnimal.Crocodile);
    }
}
