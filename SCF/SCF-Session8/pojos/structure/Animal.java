package inheritance_composition.pojos.structure;

import inheritance_composition.implementation.Category;
import inheritance_composition.implementation.TypeOfAnimal;

public class Animal {
    String id, name, sound;
    int age;
    TypeOfAnimal type;
    Category category;

    public Animal(String name, int age, String sound, TypeOfAnimal type, Category category) {
        this.name = name;
        this.sound = sound;
        this.age = age;
        this.type = type;
        this.category = category;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public TypeOfAnimal getType() {
        return type;
    }

    public String getSound() {
        return sound;
    }

    public int getAge() {
        return age;
    }

    public String getInfo() {
        return "\nDetails of the animal : " + "\nID        : " + "\nName      : " + getName() + "\nAge       : " + getAge() + " Years"
                + "\nCategory  : " + getCategory() + "\nType      : " + getType() + "\nSound     : " + getSound();
    }

}
