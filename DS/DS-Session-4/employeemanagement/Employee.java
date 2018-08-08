/**
 * Employee class that field for the employees
 */
package datastructure_4.employeemanagement;

/**
 * @author Rajendra Singh Rathore
 *
 */
public class Employee {
    private final String ID;
    private String name;
    private String address;
    
    public Employee(String id, String name, String address) {
        ID = id;
        this.name = name;
        this.address = address;
    }

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
}
