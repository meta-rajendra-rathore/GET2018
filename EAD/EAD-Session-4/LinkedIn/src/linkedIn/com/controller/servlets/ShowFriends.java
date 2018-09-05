package linkedIn.com.controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import linkedIn.com.dao.MyUserDaoMySQL;
import linkedIn.com.model.dto.FriendDto;
import linkedIn.com.model.dto.UserDto;

/**
 * Servlet implementation class ShowFriends
 */
@WebServlet("/ShowFriends")
public class ShowFriends extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFriends() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDto user = MyUserDaoMySQL.getInstance().searchUserByEmail((String) request.getSession(false).getAttribute("email")); 
		PrintWriter out = response.getWriter();
		out.write("<!DOCTYPE html>"
				+ " <html> "
				+ "<head> "
				+ "<link rel='icon' href='images/html_logo.png'> "
				+ "<title>MyProfile</title> "
				+ "<link rel='stylesheet' href='styles/basicStyles.css'> "
				+ "</head> "
				+ "<body> "
				+ "<!--This block contains the nav bar of the website--> "
				+ "<table width=70% align='center' class='nav_bar'> "
				+ "<tr> "
				+ "<td align='left'> "
				+ "<img src='images/html_logo.png' alt='HTML_LOGO' width=100px/> </td> "
				+ "<td width=100% align='right'> "
				+ "<a href='home.html'>Home</a> "
				+ "<a href='about.html'>About</a> "
				+ "<a href='product.html'>Product</a> "
				+ "<a href='gallery.html'>Gallery</a> "
				+ "<a href='contact.html'>Contact</a> "
				+ "<a href='LogoutServlet'>Logout</a> "
				+ "<span> | </span> "
				+ "<a href='ShowProfile'>");
		
		out.write(user.getFirstName());
		
		out.write(" </a> <span> </span> </td> <td align='right'> <img src='");
		
		out.write(user.getImage());
		
		out.write("' alt='User Image' width=60px id='user_image'/> "
				+ "</table> <hr> "
				+ "<!--This block contains the nav bar of the website--> <br> <br>");
		
		List<FriendDto> listOfFriends = new ArrayList<FriendDto>();
		listOfFriends = MyUserDaoMySQL.getInstance().getFriends(user);

		for (FriendDto friend : listOfFriends) {
			out.write("<table cellpadding='5px' align='center'> <tr>"
					+ "<td rowspan='3' align='left'><img src='");
			out.write(friend.getImage());
			out.write("' alt='User Image' id='upload_image' width=80px border='1' border-color='indianred'/></td> <td> ");
			out.write(friend.getFirstName() + " " + friend.getLastName());
			out.write("</td> </tr> <tr><td> ");
			out.write(friend.getEmail());
			out.write("</td> </tr> <tr><td> ");
			out.write(friend.getContact());
			out.write("</td> </tr> <tr> <td> <br> <br> </td> </tr> </table>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
