package inheritance_composition.pojos.animal_type;

import inheritance_composition.implementation.Category;
import inheritance_composition.implementation.TypeOfAnimal;
import inheritance_composition.pojos.structure.Animal;

public class Mammal extends Animal {
    String color;

    public Mammal(String name, int age, String sound, String color, TypeOfAnimal type) {
        super(name, age, sound, type, Category.Mammal);
        this.color = color;
    }
    
    public String getColor() {
        return color;
    }

    public String getInfo() {
        return "\nDetails of the animal : " + 
               "\nID       : " + getId() + 
               "\nName     : " + getName() + 
               "\nAge      : " + getAge() + " Years" + 
               "\nCategory : " + getCategory() + 
               "\nType     : " + getType() + 
               "\nSound    : " + getSound() +
               "\nColor    : " + getColor() + "\n";
    }

}