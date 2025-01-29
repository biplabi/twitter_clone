package com.bbd.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewPostDAO 
{
	public ArrayList<PostBean> retrive()
	{
		ArrayList<PostBean> al = new ArrayList<>();
		
		try
		{
			Connection conn = DBConnection.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM POSTS");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				PostBean pb = new PostBean();
				
				pb.setPostId(rs.getInt(1));
				pb.setUserId(rs.getInt(2));
				pb.setContent(rs.getString(3));
				pb.setCreatedAt(rs.getTimestamp(4));
				
				al.add(pb);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return al;
	}
}
