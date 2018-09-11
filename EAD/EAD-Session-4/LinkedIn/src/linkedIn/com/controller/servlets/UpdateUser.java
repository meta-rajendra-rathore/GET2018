package linkedIn.com.controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import linkedIn.com.enums.Status;
import linkedIn.com.util.Utilities;
import linkedIn.com.view.ViewHelper;
import linkedIn.com.model.dto.UserDto;
import linkedIn.com.model.pojo.MyUser;
import linkedIn.com.dao.MyUserDaoMySQL;

/**
 * Servlet implementation class UpdateEmployee
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUser() {
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
		
		HttpSession session = request.getSession(false);// don't create if it doesn't exist
		if(session == null || session.isNew()) { 		
			RequestDispatcher rd = request.getRequestDispatcher("home.html");
			rd.forward(request, response); 
		} 
		
		PrintWriter out = response.getWriter();

		UserDto emp = MyUserDaoMySQL.getInstance().searchUserByEmail((String) request.getSession(false).getAttribute("email"));

		out.print(ViewHelper.HEADER_CONTENT);
		//out.print("<input type='hidden' name = 'updateUser_id' value=" + emp.getId() + ">");
		out.print("<form id='update_emp_form' action = 'UpdateUserIntoDatabase'><table cellpadding='5px' align = 'center'><tr><td>First Name</td><td><input type='text' placeholder='First Name' id= 'updateUser_first_id' name = 'updateUser_first_name' required value='");
		out.print(emp.getFirstName());
		out.print("'></td></tr><tr><td>Last Name</td><td><input type='text' placeholder='Last Name' id= 'updateUser_last_id' name = 'updateUser_last_name' required value='");
		out.print(emp.getLastName());
		out.print("'></td></tr><tr><td>Email</td><td><input type='email' placeholder='Email' id= 'updateUser_id' name = 'email' required value='");
		out.print(emp.getEmail());
		out.print("'></td></tr><td>Date of Birth</td><td><input type='date' placeholder='Age' id= 'updateUser_id' name = 'updateUser_dob' required value='");
		out.print(emp.getDob());
		out.print("'></td></tr><td>Contact</td><td><input type='text' placeholder='Age' id= 'updateUser_id' name = 'updateUser_contact' required value='");
		out.print(emp.getContact());
		out.print("'></td></tr><td>Organisation</td><td><input type='text' placeholder='Age' id= 'updateUser_id' name = 'updateUser_org' required value='");
		out.print(emp.getOrganisation());
		out.print("'></td></tr><tr><td><input type='hidden' id= 'updateUser_id' name = 'updateUser_id' value='");
		out.print(emp.getId());
		out.print("'></td></tr><tr><td></td><td align='right'><input type='submit' value='Update Info' id='button_new_user'> </tr></table></form></body></html>");
		
	}

}
