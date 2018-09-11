package inheritance_composition.pojos.animals;

import inheritance_composition.implementation.TypeOfAnimal;
import inheritance_composition.pojos.animal_type.Mammal;

public class Tiger extends Mammal {
    
    public Tiger(String name, int age, String sound, String color) {
        super(name, age, sound, color, TypeOfAnimal.Tiger);
    }
}
