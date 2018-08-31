package linkedIn.com.controller.servlets;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import linkedIn.com.facade.ValidateData;
import linkedIn.com.model.pojo.MyUser;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		String firstName = request.getParameter("signup_first_name");
		String lastName = request.getParameter("signup_last_name");
		String email = request.getParameter("signup_email");
		String dob = request.getParameter("signup_dob");
		String password = request.getParameter("signup_password");
		String confirmPassword = request.getParameter("signup_confirm_password");
		String contact = request.getParameter("signup_contact");
		String organisation = request.getParameter("signup_org");
		
		if (password.equals(confirmPassword)) {
			MyUser user = new MyUser(id, firstName, lastName, email, dob, password, contact, organisation);
			new ValidateData().validateUserForSignup(user);
		} else { 
			Writer out = response.getWriter();
			out.print("")
		}
	}

}
