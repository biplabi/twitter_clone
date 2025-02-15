package com.bbd.server;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/addPost")
public class AddPostServlet extends HttpServlet
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
			String content = req.getParameter("content");
			int uId = Integer.parseInt(req.getParameter("uid"));
			
			int k = new AddPostDAO().addPost(uId, content);
			
			if(k == 0)
			{
				req.setAttribute("msg", "issues raised while posting!");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}
			else
			{
				req.setAttribute("msg", "Successfully posted!");
				req.getRequestDispatcher("home").forward(req, res);
			}
		}
	}
}
