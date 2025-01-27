package com.bbd.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/addPost")
public class AddPostServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		Connection conn = DBConnection.getConnection();
		
		try 
		{
			PreparedStatement ps = conn.prepareStatement("INSERT INTO POSTS(USER_ID, CONTENT) VALUES(?, ?, ?)");
			
			int id = Integer.parseInt(req.getParameter("uid"));
			String content = req.getParameter("content");
			
			ps.setInt(1, id);
			ps.setString(2, content);
			
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
