package inheritance_composition.pojos.animal_type;

import inheritance_composition.implementation.Category;
import inheritance_composition.implementation.TypeOfAnimal;
import inheritance_composition.pojos.structure.Animal;

public class Reptile extends Animal {
    int legs;

    public Reptile(String name, int age, String sound, int legs, TypeOfAnimal type) {
        super(name, age, sound, type, Category.Reptile);
        this.legs = legs;
    }

    public int getLegs() {
        return legs;
    }
    
    public String getInfo() {
        return "\nDetails of the animal : " +
                "\nID         : " + getId() +
                "\nName       : " + getName() +
                "\nAge        : " + getAge() + " Years" +
                "\nCategory   : " + getCategory() +
                "\nType       : " + getType() + 
                "\nSound      : " + getSound() +
                "\nNo of Legs : " + getLegs() + "\n";
    }
}