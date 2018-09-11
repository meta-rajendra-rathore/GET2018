package manageEmployees.com.controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manageEmployees.com.dao.EmployeeDaoMySQL;
import manageEmployees.com.model.pojo.Employee;
import manageEmployees.com.view.ViewHelper;

/**
 * Servlet implementation class UpdateEmployee
 */
@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Employee emp = EmployeeDaoMySQL.getInstance().searchEmployeeByID(
				request.getParameter("emp_id"));

		out.print(ViewHelper.HEADER_CONTENT);
		//out.print("<input type='hidden' name = 'updateEmp_id' value=" + emp.getId() + ">");
		out.print("<form id='update_emp_form' action = 'UpdateEmployeeIntoDatabase'><table cellpadding='5px' align = 'center'><tr><td>First Name</td><td><input type='text' placeholder='First Name' id= 'updateEmp_first_id' name = 'updateEmp_first_name' required value='");
		out.print(emp.getFirstName());
		out.print("'></td></tr><tr><td>Last Name</td><td><input type='text' placeholder='Last Name' id= 'updateEmp_last_id' name = 'updateEmp_last_name' required value='");
		out.print(emp.getLastName());
		out.print("'></td></tr><tr><td>Email</td><td><input type='email' placeholder='Email' id= 'updateEmp_id' name = 'updateEmp_email' required value='");
		out.print(emp.getEmail());
		out.print("'></td></tr><td>Age</td><td><input type='number' placeholder='Age' id= 'updateEmp_id' name = 'updateEmp_age' required value='");
		out.print(emp.getAge());
		out.print("'></td></tr><tr><td><input type='hidden' id= 'updateEmp_id' name = 'updateEmp_id' value='");
		out.print(emp.getId());
		out.print("'></td></tr><tr><td></td><td align='right'><input type='submit' value='Update Info' id='button_new_user'> </tr></table></form></body></html>");

	}

}
