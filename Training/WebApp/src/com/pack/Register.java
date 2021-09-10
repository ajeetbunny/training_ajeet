package com.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
	
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true",
					"user", "user");

			PreparedStatement ps = con.prepareStatement("insert into app.store values(?,?,?,?)");
			PreparedStatement ps1 = con.prepareStatement("select * from app.store where username=? ");
			ps.setString(1, request.getParameter("uname"));
			ps1.setString(1, request.getParameter("uname"));
			ResultSet rs=ps1.executeQuery();
			boolean status=rs.next();
			if(status==true)
			{
				PrintWriter pw=response.getWriter();
				response.setContentType("text/html");
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Username exists');");
				pw.println("window.location.assign('/WebApp/index.jsp');");
				pw.println("</script>");
			}
			else {
				
				session.setAttribute("uname", request.getParameter("uname"));
				ps.setString(2, request.getParameter("pass"));
				ps.setString(3, request.getParameter("ctype"));
				ps.setString(4, request.getParameter("bal"));
				ps.executeUpdate();
				response.sendRedirect("page.jsp");
			} }
		catch (SQLException | ClassNotFoundException e) {
				
				e.printStackTrace();
				
			}
			//return result;
			
		}
	}
	
