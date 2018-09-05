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
import linkedIn.com.facade.ValidateData;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hii bro ");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		System.out.println("hii bro " + email);
		String password = request.getParameter("signin_password");
		Status status = ValidateData.checkUserExistence(email, password);
		System.out.println(""+status);
			
		RequestDispatcher rd;
		switch (status) {
		case FAILURE:
			rd = request.getRequestDispatcher("signin.html");
			rd.forward(request, response); 
			break;
		case NOT_FOUND:
			rd = request.getRequestDispatcher("signin.html");
			rd.forward(request, response); 
			break;
		case OK:
			HttpSession oldSession = request.getSession(false);
	        if (oldSession != null) {
	            oldSession.invalidate();
	        }
	        //generate a new session
	        HttpSession newSession = request.getSession(true);
	        newSession.setAttribute("email", email); 
	
	        //setting session to expiry in 5 mins
	        newSession.setMaxInactiveInterval(5*60);
	        
			rd = request.getRequestDispatcher("ShowProfile");
			rd.include(request, response);
			break;
		}
	}

}
