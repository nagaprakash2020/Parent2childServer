package com.service.parent2childcontrol.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection
{

	private static DataSource datasource;
	
	private DBConnection()
	{
		
	}
	
	public static synchronized Connection getConnection() throws SQLException
	{
		try
		{
			if (datasource == null)
			{
				Context context = (Context) new InitialContext().lookup("java:comp/env");				
				datasource = (DataSource) context.lookup("jdbc/p2cDBlocalxxx");
			}
			
		}
		catch(NamingException e)
		{
			e.printStackTrace();
		}
		
		return datasource.getConnection();
	}
	
	
	// Ensure DBConnection object is not cloned.
	public Object clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException();
	}
}
