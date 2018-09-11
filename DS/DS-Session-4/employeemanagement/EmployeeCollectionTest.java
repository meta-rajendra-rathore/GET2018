/**
 * This class provide unit tests for EmployeeCollection class
 */
package datastructure_4.employeemanagement;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Rajendra Singh Rathore
 *
 */
public class EmployeeCollectionTest {
    EmployeeCollection employeeCollection;

    @Before
    public void init() {
        employeeCollection = new EmployeeCollection();
        employeeCollection.addEmployee(new Employee("E18", "Rajendra", "34/447 Pratapnagar"));
        employeeCollection.addEmployee(new Employee("E12", "Samrat", "34/44 Pratapnagar"));
        employeeCollection.addEmployee(new Employee("E28", "John", "35/477 Pratapnagar"));
        employeeCollection.addEmployee(new Employee("E23", "Nikhil", "39/7 Pratapnagar"));
        employeeCollection.addEmployee(new Employee("E10", "Shubham", "32/447 Pratapnagar"));
    }

    @Test
    public void addEmployeeWithUniqueID() {
        assertEquals(true,employeeCollection.addEmployee(new Employee("E20", "Ayushi", "40/447 Pratapnagar")));
    }

    @Test
    public void addEmployeeWithExistingID() {
        assertEquals(false,employeeCollection.addEmployee(new Employee("E18", "Rajesh", "34/488 Pratapnagar")));
    }

    @Test
    public void checkNaturalSorting() {
        employeeCollection.sortNaturalOrder();
        assertEquals("E18",employeeCollection.getListOfEmployee().get(2).getID());
    }

    @Test
    public void checkSortingByName() {
        employeeCollection.sortByName();        
        assertEquals("Rajendra",employeeCollection.getListOfEmployee().get(2).getName());
    }   
}
