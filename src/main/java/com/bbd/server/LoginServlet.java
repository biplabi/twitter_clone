package com.bbd.server;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String email = req.getParameter("email");
		String pWord = req.getParameter("pword");
		
		UserBean ub = new LoginDAO().login(email, pWord);
		
		if(ub == null)
		{
			req.setAttribute("msg", "Login failed!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			HttpSession hs = req.getSession();
			hs.setAttribute("ub", ub);
			
			req.setAttribute("msg", "Logged in successfully!");
			req.setAttribute("uName", ub.getuName());
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
	}
}
