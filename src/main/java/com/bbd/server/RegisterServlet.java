package com.bbd.server;

import java.io.IOException;
import java.io.InputStream;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@SuppressWarnings("serial")
@WebServlet("/register")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5) // Allow files up to 5MB
public class RegisterServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		UserBean ub = new UserBean();
		
		ub.setuName(req.getParameter("uname"));
		ub.setEmail(req.getParameter("email"));
		ub.setpWord(req.getParameter("pword"));
		
		Part filePart = req.getPart("profilepic");// Retrives the file uploaded in the form input tag with name profilepic	
		InputStream inputStream = filePart.getInputStream();//retrives the actual file content from part to inputstream
		byte[] profilePic = inputStream.readAllBytes();//storing the file content in byte form
		ub.setProfilePic(profilePic);
		
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
