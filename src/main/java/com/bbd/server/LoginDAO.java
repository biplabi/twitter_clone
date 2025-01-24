package com.bbd.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO 
{
	public UserBean login(String email, String pWord)
	{
		UserBean ub = null;
		
		try 
		{
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?");
			ps.setString(1, email);
			ps.setString(2, pWord);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				ub = new UserBean();
				ub.setuName(rs.getString(2));
				ub.setEmail(rs.getString(3));
				ub.setpWord(rs.getString(4));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return ub;
	}
}
