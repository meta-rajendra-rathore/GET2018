package linkedIn.com.controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import linkedIn.com.enums.Status;
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
		String email = request.getParameter("email");
		String dob = request.getParameter("signup_dob");
		String password = request.getParameter("signup_password");
		String confirmPassword = request.getParameter("signup_confirm_password");
		String contact = request.getParameter("signup_contact");
		String organisation = request.getParameter("signup_org");
		String image = "";
		
		Status status = null;
		
		if (password.equals(confirmPassword)) {
			MyUser user = new MyUser(id, firstName, lastName, email, dob, password, contact, organisation, image);
			status = ValidateData.validateUserForSignup(user);
		} else { 
			RequestDispatcher rd = request.getRequestDispatcher("signup.html");
			rd.forward(request, response);
			
			ScriptEngineManager factory = new ScriptEngineManager();
		    ScriptEngine engine = factory.getEngineByName("JavaScript");
		    try {
				engine.eval("var id = 'signup_confirm_password';");
				engine.eval("id.style.border=\"1px solid red\";");
				engine.eval("id.setCustomValidity(\"Password should be at least 8 character long!\");");
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (status == status.DUPLICATE || status == status.FAILURE) {
			RequestDispatcher rd = request.getRequestDispatcher("signup.html");
			rd.forward(request, response);
			// Show an alert of duplicate email
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User or password incorrect');");
			out.println("</script>");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("ShowProfile");
			rd.forward(request, response);
		}
	}

}
