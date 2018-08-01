package inheritance_composition.pojos.animal_type;

import inheritance_composition.pojos.structure.Animal;

public class Mammal extends Animal {

    public Mammal(String name, int age, String sound) {
        super(name, age, sound);
    }

    public String getInfo() { 
        return "\nDetails of the animal : " +
                "\nName     : " + getName() +
                "\nAge      : " + getAge() +  " Years" +
                "\nCategory : " + getCategory() +
                "\nType     : " + getType() + 
                "\nSound    : " + getSound();
    }

}