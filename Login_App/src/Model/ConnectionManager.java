package Model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	private static Properties loadPropertiesFile() throws Exception{
	Properties prop=new Properties();
	InputStream in=ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
	prop.load(in);
	in.close();
	return prop;
	}
	
	protected static Connection getConnection() {
		Connection connection=null;
		Properties prop=null;
		
		try {
			prop=loadPropertiesFile();
		} catch (Exception e) {
			System.out.println("Error in property file"+e);
			e.printStackTrace();
		}
		
		final String driver=prop.getProperty("driver");
		final String url=prop.getProperty("url");
		final String username=prop.getProperty("username");
		final String password=prop.getProperty("password");
		
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		/*if (connection!=null)
		{
			System.out.println("Connection Established");
		}
		else 
		{
			System.out.println("Check your connection");
		}*/
		return connection;
	}
}