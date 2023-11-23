package com.zaradev.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("authentification.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String login = request.getParameter("username");
		String pwd = request.getParameter("password");

		String url = "jdbc:mysql://localhost:3306/DB_students";
		String user = "root";
		String pass = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con;
			try {
				con = DriverManager.getConnection(url, user, pass);
				PreparedStatement pst=con.prepareStatement("SELECT id FROM users WHERE login=? AND password=?");
				pst.setString(1, login);
				pst.setString(2, pwd);
				ResultSet rs = pst.executeQuery();
				
				// parcourir db si il existe au moins 1 ligne
				if(rs.next()) {
					session.setAttribute("login", login);
					response.sendRedirect("index.jsp");
				}else {
					response.sendRedirect("authentification.jsp");	
				}
				
				rs.close();
				pst.close();
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}

	}

}
