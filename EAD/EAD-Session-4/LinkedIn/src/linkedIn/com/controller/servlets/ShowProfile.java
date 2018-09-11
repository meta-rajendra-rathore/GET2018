package linkedIn.com.controller.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import linkedIn.com.dao.MyUserDaoMySQL;
import linkedIn.com.model.dto.UserDto;
import linkedIn.com.view.ViewHelper;

/**
 * Servlet implementation class ShowProfile
 */
@WebServlet("/ShowProfile")
public class ShowProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		UserDto user = null;
		if (request.getParameter("email") == null) {
			user = MyUserDaoMySQL.getInstance().searchUserByEmail((String) request.getSession(false).getAttribute(("email")));
		} else {
			user = MyUserDaoMySQL.getInstance().searchUserByEmail(request.getParameter("email")); 
		}
		
		System.out.println(user.getImage()); 
		
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
				+ "<a href='ShowFriends'>Friends</a> "
				+ "<a href='LogoutServlet'>Logout</a> "
				+ "<span> | </span> "
				+ "<a href='ShowProfile'>");
		
		out.write(user.getFirstName());
		
		out.write(" </a> <span> </span> </td> <td align='right'> <img src='");
		
		out.write(user.getImage());
		
		out.write("' width=60px length=60px id='user_image'/> "
				+ "</table> <hr> "
				+ "<!--This block contains the nav bar of the website--> <br> <br> <div class='user_details'> <h2 style='font-family: cursive; color: lavenderBlush;'>Hii! ");
		
		out.write(user.getFirstName());
		
		out.write(". Your details are as below</h2> <table align='center' cellpadding='5px' font-size='200px'> <tr> <td rowspan='2'><img src='");
		
		out.write(user.getImage());		
		
		out.write("' alt='User Image' id='upload_image' width=80px border='1' border-color='indianred' style='cursor: pointer'/></td>"
				+ "<br /> <td align='right' style='font-size:25px'>");
		
		out.write(user.getFirstName() + " " + user.getLastName());
		
		out.write("</td> </tr> <tr> <td align='right'>");
		
		out.write(user.getEmail());
		
		out.write("</td> </tr> <tr> <td>Date of birth : </td> <td align='right'>");
		
		out.write(user.getDob());
		
		out.write("</td> </tr> <tr> <td>Contact number : </td> <td align='right'>");
		
		out.write(user.getContact());
		
		out.write("</td> </tr> <tr><td>"
				+ "Organization/Institute : </td> <td align='right'>");
		
		out.write(user.getOrganisation());
		
		out.write("</td> </tr> "
				+"<form method='POST' action='ImageUpload' enctype=\"multipart/form-data\" > "
				+ "<input type='file' id='FileUpload' name='FileUpload' style='display: none'/> <br/> "
				+ "<input type='text' value='/tmp' name='destination' style='display: none'/> </br> "
				+ "<input type='submit' value='Upload' name='upload' id='upload_button' style='display: none'/> </form> "
				
				+ "<script type='text/javascript'> "
				+ "window.onload = function () "
				+ "{ var fileupload = document.getElementById('FileUpload'); "
				+ "var button = document.getElementById('upload_button');"
				+ "var image = document.getElementById('upload_image'); "
				+ "image.onclick = function () { fileupload.click(); }; "
				+ "fileupload.onchange = function() { button.click() }; }; "
				+ "</script> </td> </tr> "
				+ "<tr> <td></td> <td align='right'><br><input type='button' onclick=\"location.href='UpdateUser'\" value=' Edit Profile ' id='button_edit_user'></td> </tr> </table> </div> </body> </html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
