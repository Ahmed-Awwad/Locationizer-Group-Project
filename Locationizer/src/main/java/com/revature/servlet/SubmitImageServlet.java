package com.revature.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.revature.dao.UserDaoImpl;
import com.revature.domain.Image;
import com.revature.domain.Users;


/**
 * Servlet implementation class SubmitRequestServlet
 */
public class SubmitImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubmitImageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = 0;
		
			List<FileItem> items = null;

			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// Parse the request
			try {
				items = upload.parseRequest(new ServletRequestContext(request));
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			InputStream is = null;
			String location = "";
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();

				if (item.isFormField()) {
					if (item.getFieldName().equals("location")) {
						location = item.getString();
					}
				} else {
					is = item.getInputStream();
				}
			}
			byte [] imageBlob = null;
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int count;
			while ((count = is.read(buffer)) != -1)
			    output.write(buffer, 0, count);
			imageBlob = output.toByteArray();
			
			
			String username = "";
			username = (String) session.getAttribute("username");
			
			// Get Users from username
			UserDaoImpl udi = new UserDaoImpl();
			Users u = udi.getUserByUsername(username);
			
			session.getAttribute("username");
			
			
			// Could turn into byte[]
			// Probably a better idea to do so in Image 
			Blob blob = null;
			try {
				blob = new SerialBlob(imageBlob);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Need to implement.
//			Image image = new Image(, user, image);
			
			// location: the location name?
			// imageBlob: image as byte array.
			
			is.close();


	}

}
