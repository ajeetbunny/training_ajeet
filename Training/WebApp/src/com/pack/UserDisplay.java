package com.pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDisplay
 */
@WebServlet("/UserDisplay")
public class UserDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDisplay() {
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

		response.getWriter().append("text/html");

		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true", "user",
					"user");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from app.store");
			response.getWriter().append("<table border=1.5 width=40% height=40%>");
			response.getWriter().append("<tr><th>Name</th><th>Account Type</th><th>Balance/Limit</th><tr>");
			while (rs.next()) {
				String username = rs.getString("username");
				String card = rs.getString("account");
				String bal = rs.getString("limit");

				response.getWriter()
						.append("<tr><td>" + username + "</td><td>" + card + "</td><td>" + bal + "</td></tr>");
			}
			response.getWriter().append("</table>");
			response.getWriter().append("</html></body>");
			con.close();

		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

}
