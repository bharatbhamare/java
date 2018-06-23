package com.javamaster.connection;


import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DbConnection 
{
private static Connection conn;
private static Session session;


static
	{
	try{
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root","");
	SessionFactory sessionfactory= new Configuration().configure().buildSessionFactory();
	session = sessionfactory.openSession();

	}catch(Exception e)
	{
		e.printStackTrace();
	}
	}
public static Connection getConnection()
{
return conn;	
}
public static Session getSession() {
	return session;
}
public static void setSession(Session session) {
	DbConnection.session = session;
}


}


