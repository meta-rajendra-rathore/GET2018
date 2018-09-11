package datastructure_2.counsellinghelper;

import java.util.List;

public class Student {
    String name;
    List<String> listOfChoices;

    public Student(String name, List<String> list) {
        this.name = name;
        listOfChoices = list;
    }

    public String getName() {
        return name;
    }

    public List<String> getListOfChoices() {
        return listOfChoices;
    }
}
