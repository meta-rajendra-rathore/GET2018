package inheritance_composition.pojos.structure;

import java.util.ArrayList;
import java.util.List;

import inheritance_composition.implementation.Category;
import inheritance_composition.implementation.TypeOfAnimal;

public class Cage {
    int capacity;
    TypeOfAnimal typeOfAnimal;
    Category categoryOfZone;
    List<Animal> listOfAnimals = new ArrayList<Animal>();

    public Cage(int capacity, Category category, TypeOfAnimal animalType) {
        this.capacity = capacity;
        this.categoryOfZone = category;
        switch (animalType) {
        case Crocodile:
            this.typeOfAnimal = TypeOfAnimal.Crocodile;
            break;
        case Tiger:
            this.typeOfAnimal = TypeOfAnimal.Tiger;
            break;
        case Peacock:
            this.typeOfAnimal = TypeOfAnimal.Peacock;
            break;
        case Lizard:
            this.typeOfAnimal = TypeOfAnimal.Lizard;
            break;
        default:
            throw new AssertionError("No such animal exists!");
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public Category getCategoryOfZone() {
        return categoryOfZone;
    }

    public TypeOfAnimal getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public boolean addAnimal(Animal animal, int zone, int i) {
        if (typeOfAnimal == animal.getType()) {
            if (listOfAnimals.size() < capacity) {
                listOfAnimals.add(animal);
                System.out.println("\n\nAnimal " + animal.getName() + " added successfully, Details are below :\nZone : " + (zone + 1)
                        + "\nCage : " + (i + 1));
                return true;
            }

        }
        return false;
    }

    public String getInfo() {
        String animals = "";
        for (Animal animal : listOfAnimals) {
            int index = 1;
            animals = "\n" + index + ". " + animal.getName();
        }
        return "\nDetails of the cage :\n\nType of animal contained : " + getTypeOfAnimal() + "\nCapacity of the cage : " + getCapacity()
                + "\nList of animals : " + animals + "\nThat's all.\n";
    }
    
    public boolean removeAnimal(String name) {
        for (Animal animal : listOfAnimals) {
            if (name.equals(animal.getName())) {
                listOfAnimals.remove(animal);
                return true;
            }
        }
        return false;
    }
    
    public String getAnimalInfo(String name) {
        for (Animal animal : listOfAnimals) {
            if (name.equals(animal.getName())) {
                return animal.getInfo();
            }
        }
        return "null";
    }
}
