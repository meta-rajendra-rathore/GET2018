package inheritance_composition.pojos.animal_type;

import inheritance_composition.pojos.structure.Animal;

public class Reptile extends Animal {
    int legs;

    public Reptile(String name, int age, String sound) {
        super(name, age, sound);
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public int getLegs() {
        return legs;
    }
    
    public String getInfo() {
        return "\nDetails of the animal : " +
                "\nName       : " + getName() +
                "\nAge        : " + getAge() + " Years" +
                "\nCategory   : " + getCategory() +
                "\nType       : " + getType() + 
                "\nSound      : " + getSound() +
                "\nNo of Legs : " + getLegs();
    }
}