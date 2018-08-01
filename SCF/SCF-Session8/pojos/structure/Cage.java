package inheritance_composition.pojos.structure;

import java.util.ArrayList;
import java.util.List;

import inheritance_composition.implementation.Category;
import inheritance_composition.implementation.TypeOfAnimal;

public class Cage {
    int pointer;
    int capacity;
    TypeOfAnimal typeOfAnimal;
    Category categoryOfZone;
    List<Animal> listOfAnimals = new ArrayList<Animal>();

    public Cage(int capacity, Category category, TypeOfAnimal animalType) {
        pointer = 1;
        this.capacity = capacity;
        this.categoryOfZone = category;
        this.typeOfAnimal = animalType;
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
                animal.setId("" + (zone + 1) + "-" + (i + 1) + "-" + pointer++);
                return true;
            }

        }
        return false;
    }

    public String getInfo() {
        String animals = "";
        int index = 1;
        for (Animal animal : listOfAnimals) {
            animals += "\n" + index++ + ". " + animal.getName();
        }
        return "\nDetails of the cage :\n\nType of animal contained : " + getTypeOfAnimal() + "\nCapacity of the cage : " + getCapacity()
                + "\nList of animals : " + animals + "\nThat's all.\n\n";
    }
    
    public boolean removeAnimal(String name) {
        for (Animal animal : listOfAnimals) {
            if (name.equals(animal.getName())) {
                listOfAnimals.remove(animal);
                System.out.println("\nAnimal " + animal.getName() + " was removed successfully.");
                return true;
            }
        }
        return false;
    }
    
    public String getAnimalInfo(String id) {
       for (Animal animal : listOfAnimals) {
           if (animal.getId().equals(id)) {
               return animal.getInfo();
           }
       }
       return null;
        /*for (Animal animal : listOfAnimals) {
            if (name.equals(animal.getName())) {
                return animal.getInfo();
            }
        }
        return "null";*/
    }
}
