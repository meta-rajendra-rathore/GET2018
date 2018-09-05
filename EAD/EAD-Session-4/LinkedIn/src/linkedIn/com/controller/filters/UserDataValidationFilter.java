package linkedIn.com.controller.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UserDataValidationFilter
 */
@WebFilter(filterName = "UserDataValidationFilter", urlPatterns = { "/SignUpServlet" })
public class UserDataValidationFilter implements Filter {
	private ServletContext context;

	/**
	 * Default constructor.
	 */
	public UserDataValidationFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String firstName = request.getParameter("signup_first_name");
		String lastName = request.getParameter("signup_last_name");
		String email = request.getParameter("email");
		String dob = request.getParameter("signup_dob");
		String password = request.getParameter("signup_password");
		String confirmPassword = request
				.getParameter("signup_confirm_password");
		String contact = request.getParameter("signup_contact");
		String organisation = request.getParameter("signup_org");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		if (checkName(firstName + " " + lastName) && checkEmail(email) && checkContact(contact)) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		} else {
			res.sendRedirect(req.getContextPath() + "/signup.html");
			PrintWriter writer = res.getWriter();
			writer.write("<script>alert('Please enter valid data!');</script>);");
			writer.close();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		/*
		 * this.context = fConfig.getServletContext();
		 * this.context.log("AuthenticationFilter initialized");
		 */
	}

	private boolean checkName(String name) {
		if (name.matches("[A-Za-z ]{5,}")) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkEmail(String email) {
		if (email.matches("\\w+([\\.-]?\\w+)*@[a-zA-Z]+(.[a-zA-Z]{2,3})+")) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkContact(String contact) {
		if (contact.matches("[0-9]{8,}")) {
			return true;
		} else {
			return false;
		}
	}
}
