package com.bbd.server;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddPostDAO 
{
	public int addPost(int id, String content)
	{
		int k = 0;
		
		try
		{
			Connection conn = DBConnection.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO POSTS(USER_ID, CONTENT) VALUES(?, ?)");
			ps.setInt(1, id);
			ps.setString(2, content);
			
			k = ps.executeUpdate();
			
			ps.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return k;
	}
}
