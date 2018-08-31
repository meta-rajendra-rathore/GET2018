package inheritance_composition.pojos.animal_type;

import inheritance_composition.implementation.Category;
import inheritance_composition.implementation.TypeOfAnimal;
import inheritance_composition.pojos.structure.Animal;

public class Bird extends Animal {
    int flightInMeters;

    public Bird(String name, int age, String sound, int flight, TypeOfAnimal type) {
        super(name, age, sound, type, Category.Bird);
        this.flightInMeters = flight;
    }

    public int getFlightInMeters() {
        return flightInMeters;
    }

    public String getInfo() {
        return "\nDetails of the animal : " + "\nID        : " + getId() + "\nName      : " + getName() + "\nAge       : " + getAge() + " Years"
                + "\nCategory  : " + getCategory() + "\nType      : " + getType() + "\nSound     : " + getSound()
                + "\nFlight(m) : " + getFlightInMeters() + "\n";
    }
}
