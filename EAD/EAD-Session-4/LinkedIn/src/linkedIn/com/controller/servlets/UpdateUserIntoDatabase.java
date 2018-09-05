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
import linkedIn.com.model.dto.UserDto;
import linkedIn.com.model.pojo.MyUser;
import linkedIn.com.dao.MyUserDaoMySQL;

/**
 * Servlet implementation class UpdateuserloyeeIntoDatabase
 */
@WebServlet("/UpdateUserIntoDatabase")
public class UpdateUserIntoDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserIntoDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("updateUser_id"));
		String first_name = request.getParameter("updateUser_first_name");
		String last_name = request.getParameter("updateUser_last_name");
		String email = request.getParameter("updateUser_email");
		String dob = request.getParameter("updateUser_dob");
		String contact = request.getParameter("updateUser_contact");
		String organisation = request.getParameter("updateUser_org");
		String image = "";
		
		UserDto user = new UserDto(id, first_name, last_name, email, dob, contact, organisation, image);
		Status status = MyUserDaoMySQL.getInstance().updateUser(id, user);
		System.out.println("" + status);
		
		RequestDispatcher view = request.getRequestDispatcher("ShowProfile");
		view.forward(request, response);
	}
}
