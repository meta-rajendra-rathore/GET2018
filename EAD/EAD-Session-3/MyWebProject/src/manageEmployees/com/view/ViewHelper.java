package manageEmployees.com.view;

public final class ViewHelper {
	public static String HEADER_CONTENT = "<!DOCTYPE html> " + 
			" <html> " + 
	" <head> " + 
	" <link rel='icon' href='images/html_logo.png'> " + 
		" <title>Add New employee</title> " + 
		" <link rel='stylesheet' href='styles/basicStyles.css'> " + 
		" </head> " + 
	" <body> " + 
	" <!--This block contains the nav bar of the website--> " + 
		" <table width=70% align='center' class='nav_bar'> " + 
		" <tr> " + 
			" <td colspan='1' align='left'> " + 
				" <img src='images/html_logo.png' alt='HTML_LOGO' width=100px/> " + 
					" </td> " + 
				" <td colspan='1' align='right'> " + 
				" <a href='home.html'>Home</a> " + 
					" <a href='about.html'>About</a> " + 
					" <a href='product.html'>Product</a> " + 
					" <a href='gallery.html'>Gallery</a> " + 
					" <a href='contact.html'>Contact</a> " + 
					" <a href='signin.html'>Sign In</a> " + 
					" <a href='search_emp.html'>New User?</a> " + 
					" </td> " + 
				" </tr> " + 
			" </table> " + 
		
		" <hr> ";
	
	public static String MID_CONTENT = "<h2>The details of relevant employees : </h3> <table cellpadding='5px' align='center'>";
	
	public static String EMPLOYEE_CONTENT = 
			"<tr> <td colspan='2' align='left'><h3>" +
			/*employee name here*/
			"</h3></td> </tr> <tr> <td><b>Email : </b></td> <td style='color: lavenderBlush'>" +
			/*rajendra@gmail.com*/
			"</td> </tr> <tr> <td><b>Age : </b></td> <td style='color: lavenderBlush'>" +
			/*22*/
			"Years</td> </tr>";
	
	public static String END_CONTENT = "</table> </body> </html>";
}
