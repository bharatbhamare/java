package com.javamaster.connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnection 
{
private static Connection conn;


static
	{
	try{
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	}
public static Connection getConnection()
{
return conn;	
}

public void empty()
{
	}
}


