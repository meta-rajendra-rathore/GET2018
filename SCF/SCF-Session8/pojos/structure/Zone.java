package inheritance_composition.pojos.structure;


import java.util.ArrayList;
import java.util.List;

import inheritance_composition.implementation.Category;

public class Zone {
    int capacity;
    Category category;
    boolean hasPark, hasCanteen;
    List<Cage> listOfCages = new ArrayList<Cage>();
    
    public Zone(int capacity, Category category, boolean hasPark, boolean hasCanteen) {
        this.capacity = capacity;
        this.category = category;
        this.hasPark = hasPark;
        this.hasCanteen = hasCanteen;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public Category getCategoryOfZone() {
        return category;
    }

    public boolean addCage(Cage cage) {
        if (category == cage.getCategoryOfZone()) {
            if (listOfCages.size() < capacity) {
                listOfCages.add(cage);
                return true;
            } else {
                System.out.println("Zone has reached it's limit. Can not add cage.");
                return false;
            }

        } else {
            System.out.println("Can not add the cage to this category of zone.");
            return false;
        }
    }

    public boolean addAnimal(Animal animal, int zone) {
        for (Cage cage : listOfCages) {
            if (cage.getTypeOfAnimal() == animal.getType()) {
                if (cage.addAnimal(animal, zone, listOfCages.indexOf(cage))) {
                    return true;
                } 
            }
        }
        return false;
    }
    
    public boolean removeAnimal(String name) {
        for (Cage cage : listOfCages) {
            if (cage.removeAnimal(name))
                return true;
        }
        return false;
    }
    
    public String getAnimalInfo(int cageNo, String id) {
        return listOfCages.get(cageNo).getAnimalInfo(id);
        /*for (Cage cage : listOfCages) {
            if (!cage.getAnimalInfo(name).equals("null"))
                return cage.getAnimalInfo(name);
        }
        return "null";*/
    }
}
