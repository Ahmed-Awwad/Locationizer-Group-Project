package com.revature.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.dao.ImageDao;
import com.revature.dao.ImageDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.Image;
import com.revature.domain.Users;

/**
 * Servlet implementation class GetImageServlet
 */
public class GetImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetImageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session != null) {

		} else {
			response.sendRedirect("login");
		}
		
		UserDaoImpl udi = new UserDaoImpl();
		ImageDaoImpl idi = new ImageDaoImpl();

		// Get User id from User via username
		String username = (String) session.getAttribute("username");
		
		// Use username to get Users object.
		// Use ID of Users object to obtain images
		Users u = udi.getUserByUsername(username);
		int id = u.getId();
		
		// Filter images for those with a specific User Id
		// This could be put into a utility class
		List<Image> imageList = idi.getImages();
		Iterator<Image> it = imageList.iterator();
		while(it.hasNext()) {
			if(it.next().getUser().getId()!=id) {
				it.remove();
			}
		}
		
		// Use GSON to send over Image
		Gson gson = new Gson();
		response.setContentType("JSON");
		PrintWriter pw = response.getWriter();
		pw.write(gson.toJson(imageList));
		pw.flush();
	}

}
