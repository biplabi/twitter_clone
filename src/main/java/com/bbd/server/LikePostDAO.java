package com.bbd.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LikePostDAO 
{
	public int like(int pId, int uId)
	{
		int k = 0;
		
		try
		{
			Connection conn = DBConnection.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM LIKES WHERE POST_ID = ? AND USER_ID = ?");
			ps.setInt(1, pId);
			ps.setInt(2, uId);
			
			ResultSet rs = ps.executeQuery();
			
			if(!rs.next())
			{
				PreparedStatement ps1 = conn.prepareStatement("INSERT INTO LIKES(POST_ID, USER_ID) VALUES(?, ?)");
				ps1.setInt(1, pId);
				ps1.setInt(2, uId);
				
				k = ps1.executeUpdate();
				
				PreparedStatement ps2 = conn.prepareStatement("SELECT COUNT(*) FROM LIKES WHERE POST_ID = ?");
				ps2.setInt(1, pId);
				
				ResultSet rs1 = ps2.executeQuery();
				
				if(rs1.next())
				{
					PreparedStatement ps3 = conn.prepareStatement("UPDATE POSTS SET LIKE_COUNT = ? WHERE POST_ID = ?");
					ps3.setInt(1, rs1.getInt(1));
					ps3.setInt(2, pId);
					ps3.executeUpdate();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return k;
	}
}
