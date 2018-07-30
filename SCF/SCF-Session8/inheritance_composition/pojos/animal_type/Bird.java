package inheritance_composition.pojos.animal_type;

import inheritance_composition.pojos.structure.Animal;

public class Bird extends Animal {
    public Bird(String name, int age, String sound, int flight) {
        super(name, age, sound);
        setFlightInMeters(flight);
    }

    int flightInMeters;
    
    public void setFlightInMeters(int flight) {
        this.flightInMeters = flight;
    }
    
    public int getFlightInMeters() {
        return flightInMeters;
    }
    
    public String getInfo() {
        return "\nDetails of the animal : " +
                "\nName      : " + getName() +
                "\nAge       : " + getAge() +  " Years" +
                "\nCategory  : " + getCategory() +
                "\nType      : " + getType() + 
                "\nSound     : " + getSound() +
                "\nFlight(m) : " + getFlightInMeters();
    }
}
