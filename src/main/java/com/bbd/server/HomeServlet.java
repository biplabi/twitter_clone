package com.bbd.server;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Here we use HomeServlet for retrieving all the posts and sending to Home.jsp to display
 * in the feed of users
 * 
 */
@SuppressWarnings("serial")
@WebServlet("/home")
public class HomeServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);
		
		if(hs == null)
		{
			req.setAttribute("msg", "Session expired!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			ArrayList<PostBean> al = new ViewPostDAO().retrive();
			
			hs.setAttribute("al", al);
			
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
	}
}
