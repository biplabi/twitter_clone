package com.bbd.server;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddPostDAO 
{
	public int addPost(int uId, String content)
	{
		int k = 0;
		
		try
		{
			Connection conn = DBConnection.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO POSTS(USER_ID, CONTENT) VALUES(?, ?)");
			ps.setInt(1, uId);
			ps.setString(2, content);
			
			k = ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return k;
	}
}
