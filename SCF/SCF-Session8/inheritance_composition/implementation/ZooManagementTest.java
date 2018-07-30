package inheritance_composition.implementation;

import static org.junit.Assert.*;
import inheritance_composition.pojos.animals.*;
import inheritance_composition.pojos.structure.*;

import org.junit.Test;

public class ZooManagementTest {
    
    ZooManagement zoo = new ZooManagement(5);

    @Test
    public void test3() {

        Zone zone1 = new Zone(5, Category.Mammal, true, true);
        Zone zone2= new Zone(5, Category.Bird, true, true);
        Zone zone3= new Zone(3, Category.Reptile, true, true);
        Zone zone4= new Zone(5, Category.Mammal, true, true);

        zoo.addZone(zone1);
        zoo.addZone(zone2);
        zoo.addZone(zone3);
        zoo.addZone(zone4);
        
        Cage cage1 = new Cage(1, Category.Mammal, TypeOfAnimal.Tiger);
        Cage cage2 = new Cage(1, Category.Reptile, TypeOfAnimal.Crocodile);
        Cage cage3 = new Cage(2, Category.Reptile, TypeOfAnimal.Lizard);

        zoo.addCage(cage1);
        zoo.addCage(cage2);
        zoo.addCage(cage3);
        
        Animal tiger1 = new Tiger("Shera", 5, "MEOW");
        Animal tiger2 = new Tiger("Veera", 7, "Roars");
        Animal croco = new Crocodile("John", 12, "Gurr", 4);
        Animal lizard = new Lizard("Chitti", 2, "Shhh", 6);
        
        assertEquals(true, zoo.addAnimal(tiger1));
        assertEquals(false, zoo.addAnimal(tiger2));
        assertEquals(true, zoo.addAnimal(tiger2));
        assertEquals(true, zoo.addAnimal(croco));
        assertEquals(true, zoo.addAnimal(lizard));

        System.out.print(cage1.getInfo());
        assertEquals(true, zoo.removeAnimal("Shera"));
        System.out.print(cage1.getInfo());
        
        System.out.print(cage2.getInfo());
        System.out.print(zoo.getAnimalInfo("Shera"));
    }

}
