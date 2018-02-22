package com.revature.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		/*
		 * Turn the BAOS into a byte array Send byte array into response via
		 * ServletOutputStream.
		 */
		
		Blob blob = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int length=0;
		InputStream in =null;
		if (blob != null) {

			
			try {
				in = blob.getBinaryStream();
				length = (int) blob.length();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];

			while ((length = in.read(buffer)) != -1) {
				out.write(buffer, 0, length);
			}
		}

		byte[] buf = out.toByteArray();
		response.setContentLength(buf.length);
		ServletOutputStream sos = response.getOutputStream();
		sos.write(buf);
		sos.close();

		// if(image_blob==null) {
		// } else {
		//// response.get
		// }

	}

}
