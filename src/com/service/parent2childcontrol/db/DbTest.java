package com.service.parent2childcontrol.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/dbtest")
public class DbTest
{

	@GET
	@Produces({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
	public String testDB()
	{
		
		Connection        conn;
		PreparedStatement ps;
		ResultSet         rs;
		String            result = null;
		
		try
		{
			String dbTime = "select Now() as time";
			
			conn = DBConnection.getConnection();
			ps   = conn.prepareStatement(dbTime);
			rs   = ps.executeQuery();
			
			while(rs.next())
			{
				result = rs.getString("time");
			}
						
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
}
