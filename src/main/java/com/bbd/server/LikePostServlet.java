package com.bbd.server;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/like")
public class LikePostServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);
		
		if(hs == null)
		{
			req.setAttribute("msg", "Session expired!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);			
		}
		else
		{
			int pId = Integer.parseInt(req.getParameter("pid"));
			int uId = Integer.parseInt(req.getParameter("uid"));
			
			int k = new LikePostDAO().like(pId, uId);
			
			if(k == 0)
			{
				req.setAttribute("msg", "error in liking the post!");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}
			else
			{
				req.setAttribute("msg", "Liked post successfully!");
				req.getRequestDispatcher("home").forward(req, res);
			}
		}
	}
}
