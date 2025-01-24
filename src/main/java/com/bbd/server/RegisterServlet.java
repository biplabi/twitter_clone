package com.bbd.server;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		UserBean ub = new UserBean();
		
		ub.setuName(req.getParameter("uname"));
		ub.setEmail(req.getParameter("email"));
		ub.setpWord(req.getParameter("pword"));
		
		RegisterDAO ob = new RegisterDAO();
		
		int k = ob.register(ub);
		
		if(k > 0)
		{
			req.setAttribute("msg", "Registration successful!");
			RequestDispatcher rd = req.getRequestDispatcher("RegisterSuccess.jsp");
			rd.forward(req, res);
		}
		else
		{
			req.setAttribute("msg", "Rgistration failed!");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
	}
}
