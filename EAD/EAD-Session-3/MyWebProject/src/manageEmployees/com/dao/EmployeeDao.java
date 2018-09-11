package manageEmployees.com.dao;

import java.util.List;

import manageEmployees.com.model.pojo.Employee;
import manageEmployees.com.enums.Status;

public interface EmployeeDao {
	public List<Employee> getAllEmployees();
	public List<Employee> searchEmployees(String searchQuery);
	public Status addEmployee(Employee employee); 
	public Status updateEmployee(int id, Employee employee);
	public Employee searchEmployeeByID(String searchQuery);
}
