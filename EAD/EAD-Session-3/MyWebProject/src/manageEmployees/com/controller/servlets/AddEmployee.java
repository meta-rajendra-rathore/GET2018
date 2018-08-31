package manageEmployees.com.controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manageEmployees.com.dao.EmployeeDao;
import manageEmployees.com.dao.EmployeeDaoMySQL;
import manageEmployees.com.model.pojo.Employee;
import manageEmployees.com.enums.Status;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		String first_name = request.getParameter("addEmp_first_name");
		String last_name = request.getParameter("addEmp_last_name");
		String email = request.getParameter("addEmp_email");
		int age = Integer.parseInt(request.getParameter("addEmp_age"));
		
		Employee emp = new Employee(id, first_name, last_name, email, age);
		Status status = EmployeeDaoMySQL.getInstance().addEmployee(emp);
		System.out.println("" + status);
		
		RequestDispatcher view = request.getRequestDispatcher("ShowAllEmployees");
		view.forward(request, response);
	}

}
