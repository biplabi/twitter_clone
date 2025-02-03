package com.bbd.server;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LikePostDAO 
{
	public int like(int pId, int uId)
	{
		int k = 0;
		
		try
		{
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO LIKES(POST_ID, USER_ID) VALUES(?, ?)");
			ps.setInt(1, pId);
			ps.setInt(2, uId);
			
			k = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return k;
	}
}
