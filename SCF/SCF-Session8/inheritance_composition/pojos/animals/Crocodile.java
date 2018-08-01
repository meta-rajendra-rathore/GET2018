package inheritance_composition.pojos.animals;

import inheritance_composition.pojos.animal_type.Reptile;

public class Crocodile extends Reptile{
    
    public Crocodile(String name, int age, String sound, int legs) {
        super(name, age, sound);
        setLegs(legs);
    }
    
    public static void main(String[] args) {
        Crocodile c = new Crocodile("titar", 5, "hurr hurr", 4);
        System.out.println(c.getInfo());
    }
}
