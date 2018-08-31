package linkedIn.com.controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import linkedIn.com.enums.Status;
import linkedIn.com.util.Utilities;
import linkedIn.com.model.pojo.MyUser;
import linkedIn.com.dao.MyUserDaoMySQL;

/**
 * Servlet implementation class UpdateEmployeeIntoDatabase
 */
@WebServlet("/UpdateEmployeeIntoDatabase")
public class UpdateEmployeeIntoDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeIntoDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("updateEmp_id"));
		String first_name = request.getParameter("updateEmp_first_name");
		String last_name = request.getParameter("updateEmp_last_name");
		String email = request.getParameter("updateEmp_email");
		String dob = request.getParameter("updateEmp_age");
		
		MyUser emp = new MyUser(id, first_name, last_name, email, dob, email, email, email);
		Status status = MyUserDaoMySQL.getInstance().updateEmployee(id, emp);
		System.out.println("" + status);
		
		RequestDispatcher view = request.getRequestDispatcher("ShowAllEmployees");
		view.forward(request, response);
	}
}
