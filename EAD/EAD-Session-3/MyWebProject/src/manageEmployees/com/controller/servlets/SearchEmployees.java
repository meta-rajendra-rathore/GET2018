package manageEmployees.com.controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import manageEmployees.com.enums.Status;
import manageEmployees.com.model.pojo.Employee;
import manageEmployees.com.view.ViewHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manageEmployees.com.dao.EmployeeDaoMySQL;

/**
 * Servlet implementation class SearchEmployees
 */
@WebServlet("/SearchEmployees")
public class SearchEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchQuery = request.getParameter("search_emp_query");
		List<Employee> listOfEmployeesInSearch = EmployeeDaoMySQL.getInstance().searchEmployees("%" + searchQuery + "%");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print(ViewHelper.HEADER_CONTENT);
		out.print("<h1>" + listOfEmployeesInSearch.size() + " out of all employees match your query</h2>");
		
		if (listOfEmployeesInSearch.size() > 0) {
			out.print(ViewHelper.MID_CONTENT);
			
			for (Employee emp : listOfEmployeesInSearch) {
				out.print("<input type='hidden' name = 'emp_id' value=" + emp.getId() + ">");
				out.print("<tr> <td colspan='2' align='left'><h3>");
				out.print("<a style='font-size:20px' href='UpdateEmployee?emp_id=" + emp.getId() + "'>" + emp.getFirstName() + " " + emp.getLastName() +"</a>");
				out.print("</h3></td> </tr> <tr> <td><b> Email : </b></td> <td style='color: lavenderBlush'>");
				out.print(emp.getEmail());
				out.print("</td> </tr> <tr> <td><b> Age : </b></td> <td style='color: lavenderBlush'>");
				out.print("" + emp.getAge());
				out.print(" Years</td> </tr>");
			}
			
			out.print(ViewHelper.END_CONTENT);
		}
	}
}
