package com.bbd.server;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
	private static Connection conn = null;
	
	private DBConnection() {}
	
	static
	{
		try 
		{
			Class.forName(DBInfo.DriverName);
			conn = DriverManager.getConnection(DBInfo.DBUrl, DBInfo.DBName, DBInfo.DBPword);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	{
		return conn;
	}
}
