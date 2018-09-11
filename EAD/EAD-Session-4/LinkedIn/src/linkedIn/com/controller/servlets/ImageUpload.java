package linkedIn.com.controller.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import linkedIn.com.dao.MyUserDaoMySQL;
import linkedIn.com.util.Utilities;

/**
 * Servlet implementation class ImageUpload
 */
@MultipartConfig
@WebServlet("/ImageUpload")
public class ImageUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String email = (String) request.getSession(false).getAttribute("email");
		final Part filePart = request.getPart("FileUpload");
		final String fileName = email.split("@")[0] + ".JPEG";
		OutputStream out = null;
		InputStream filecontent = null;
		final PrintWriter writer = response.getWriter();
		//String imageURL = Utilities.USER_IMAGE_PATH + File.separator + fileName;
		String imageURL = "images/users/" + fileName;
		out = new FileOutputStream(new File(Utilities.USER_IMAGE_PATH + File.separator + fileName));
		filecontent = filePart.getInputStream();

		int read = 0;
		final byte[] bytes = new byte[1024];

		while ((read = filecontent.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		
		//String imageURL = "images/users/" + fileName;
		MyUserDaoMySQL.getInstance().uploadImage(imageURL, email);
		
		RequestDispatcher rd = request.getRequestDispatcher("ShowProfile");
		rd.forward(request, response); 
		writer.close();
		out.close();
	}
}
