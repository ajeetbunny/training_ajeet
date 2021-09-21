package com.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();  

		boolean status = false;

		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true",
					"user", "user");

			PreparedStatement ps = connection.prepareStatement("select * from app.store where username=? and password=?");

			ps.setString(1, request.getParameter("uname"));
			ps.setString(2, request.getParameter("pass"));
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			if (status == true) {
				session.setAttribute("uname", request.getParameter("uname"));
	            request.getRequestDispatcher("/page.jsp").forward(request, response);
			}
			else {
				response.setContentType("text/html");  
				pw.println("<script type=\"text/javascript\">");  
				pw.println("alert('Invalid Username or Password');");  
				pw.println("window.location.assign('/WebApp/login.jsp');");  
				pw.println("</script>");
	            
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}

}