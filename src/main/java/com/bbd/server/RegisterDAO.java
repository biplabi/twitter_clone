package com.bbd.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO 
{
	public int register(UserBean ub)
	{
		int k = 0;
		
		Connection conn = DBConnection.getConnection();
		
		
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO USERS(USERNAME, EMAIL, PASSWORD) VALUES(?, ?, ?)");
			
			ps.setString(1, ub.getuName());
			ps.setString(2, ub.getEmail());
			ps.setString(3, ub.getpWord());
			
			k = ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return k;
	}
}
