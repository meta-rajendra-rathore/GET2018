package inheritance_composition.pojos.animals;

import inheritance_composition.pojos.animal_type.Reptile;

public class Lizard extends Reptile{
    
    public Lizard(String name, int age, String sound, int legs) {
        super(name, age, sound);
        setLegs(legs);
    }
    
    public static void main(String[] args) {
    	Lizard c = new Lizard("lizardName", 2, "ssssssss", 4);
        System.out.println(c.getInfo());
    }
}
