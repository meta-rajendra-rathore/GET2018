package inheritance_composition.implementation;


import java.util.ArrayList;
import java.util.List;

import inheritance_composition.pojos.structure.Animal;
import inheritance_composition.pojos.structure.Cage;
import inheritance_composition.pojos.structure.Zone;


public class ZooManagement {
    int capacity;
    List<Zone> listOfZones = new ArrayList<Zone>();

    public ZooManagement(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean addZone(Zone zone) {
        if (listOfZones.size() < capacity) {
            listOfZones.add(zone);
            return true;
        } else {
            System.out.println("\nZoo has reached its limit. Cannot add zone.\n");
            return false;
        }
    }

    public boolean addCage(Cage cage) {
        for (Zone zone : listOfZones){
            if (cage.getCategoryOfZone() == zone.getCategoryOfZone()) {
                if (zone.addCage(cage)) {
                    return true;
                } 
            } 
        }
        return false;
    }

    public boolean addAnimal(Animal animal) {
        for (Zone zone : listOfZones) {
            if (zone.getCategoryOfZone() == animal.getCategory()) {
                if (zone.addAnimal(animal, listOfZones.indexOf(zone))) {
                    return true;
                } 
            }
        }
        System.out.println("\nAnimal " + animal.getName() + " could not be added!");
        Cage cage = new Cage(1, animal.getCategory(), animal.getType());
        addCage(cage);
        return false;
    }
    
    public boolean removeAnimal(String name) {
        for (Zone zone : listOfZones) {
            if (zone.removeAnimal(name))
                return true;
        }
        return false;
    }
    
    public String getAnimalInfo(String id) {
        String[] separatedID = id.split("-"); 
        int[] idParts = {Integer.parseInt(separatedID[0]), Integer.parseInt(separatedID[1])};
        
        return listOfZones.get(idParts[0]-1).getAnimalInfo(idParts[1]-1, id);
        /*for (Zone zone : listOfZones) {
            String info = zone.getAnimalInfo(name);
            if (!info.equals("null"))
                return info;
        }
        return "null";*/
    }
}
