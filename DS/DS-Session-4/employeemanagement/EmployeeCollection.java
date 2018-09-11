/**
 * This class provide a collection for Employee class and functions to operate upon it
 */
package datastructure_4.employeemanagement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rajendra Singh Rathore
 *
 */
public class EmployeeCollection {
    List<Employee> listOfEmployee;    

    public EmployeeCollection() {
        listOfEmployee = new ArrayList<Employee>();
    }
    
    /**
     * @return the listOfEmployee
     */
    public List<Employee> getListOfEmployee() {
        return listOfEmployee;
    }

    /**
     * this function checks if the given ID already exists for another employee
     * @param id
     * @return true if ID already exists and false otherwise
     */
    public boolean isAlreadyEmployee(String id) {
        for (Employee emp : listOfEmployee) {
            if (id.equals(emp.getID())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a new employee to the collection
     * @param employee
     * @return true if employee added successfully and false otherwise 
     */
    public boolean addEmployee(Employee employee) {
        if (isAlreadyEmployee(employee.getID())) {
            return false;
        }

        listOfEmployee.add(employee);
        return true;
    }

    /**
     * Sort the collection by natural order that is ID
     */
    public void sortNaturalOrder() {
        for (int i = 0; i < listOfEmployee.size() - 1; i++) {
            for (int j = 0; j < listOfEmployee.size() - i - 1; j++) {
                String employee1ID = listOfEmployee.get(j).getID();
                String employee2ID = listOfEmployee.get(j + 1).getID();
                if (employee1ID.compareTo(employee2ID) > 0) {
                    Employee tmp = listOfEmployee.get(j);
                    Employee tmp2 = listOfEmployee.get(j + 1);
                    listOfEmployee.remove(j);
                    listOfEmployee.add(j, tmp2);
                    listOfEmployee.remove(j + 1);
                    listOfEmployee.add(j + 1, tmp);
                }
            }
        }
    }

    /**
     * Sort the collection by name
     */
    public void sortByName() {
        for (int i = 0; i < listOfEmployee.size() - 1; i++) {
            for (int j = 0; j < listOfEmployee.size() - i - 1; j++) {
                String employee1Name = listOfEmployee.get(j).getName();
                String employee2Name = listOfEmployee.get(j + 1).getName();
                if (employee1Name.compareTo(employee2Name) > 0) {
                    Employee tmp = listOfEmployee.get(j);
                    Employee tmp2 = listOfEmployee.get(j + 1);
                    listOfEmployee.remove(j);
                    listOfEmployee.add(j, tmp2);
                    listOfEmployee.remove(j + 1);
                    listOfEmployee.add(j + 1, tmp);
                }
            }
        }
    }
}
