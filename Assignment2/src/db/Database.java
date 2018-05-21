package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
static Connection connection = null;

	
	public static void DBConnection() throws Exception {
//		Server hsqlServer = null;

//		hsqlServer = new Server();
//		hsqlServer.setLogWriter(null);
//		hsqlServer.setSilent(true);
//		hsqlServer.setDatabaseName(0, "TestDB");
//		hsqlServer.setDatabasePath(0, "file:MYDB");	
//		hsqlServer.start();
		
		// making a connection
		try {
			//Registering the HSQLDB JDBC driver
			Class.forName("org.hsqldb.jdbcDriver");
			//Creating the connection with HSQLDB
			connection = DriverManager.getConnection("jdbc:hsqldb:TestDB", "sa", "");
			if (connection!= null) {
				System.out.println("Connection created successfully");
			}
			
			else{
				System.out.println("Problem with creating connection");
			}
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		// end of stub code for in/out stub
	}
	
	public static void DBCreate() {
		
		try {
			//Registering the HSQLDB JDBC driver
			Class.forName("org.hsqldb.jdbcDriver");
			//Creating the connection with HSQLDB
			connection = DriverManager.getConnection("jdbc:hsqldb:TestDB", "sa", "");
			
			connection.prepareStatement("DROP TABLE people IF EXISTS;").execute();
			connection.prepareStatement("DROP TABLE relation IF EXISTS;").execute();
			connection.prepareStatement("CREATE TABLE people (fullname VARCHAR(50) NOT NULL, "
															+ "profile VARCHAR(50), "
															+ "status VARCHAR(50), "
															+ "gender VARCHAR(10), "
															+ "age INT NOT NULL, "
															+ "state VARCHAR(3), "
															+ "PRIMARY KEY (fullname));").execute();
						
//			connection.prepareStatement("CREATE TABLE relation (personne VARCHAR(50) NOT NULL, "
//															+ "persontwo VARCHAR(50) NOT NULL, "
//															+ "relationship VARCHAR(50) NOT NULL;").execute();			
			
			connection.commit();
			
		}catch(Exception e ) {
			e.printStackTrace(System.out);
		}
		System.out.println("Table created successfully");
	}
	
	public static void DBInsert() throws Exception {
		
		int result = 0;
		ResultSet rs = null;
		
		try {
			//Registering the HSQLDB JDBC driver
			Class.forName("org.hsqldb.jdbcDriver");
			//Creating the connection with HSQLDB
			connection = DriverManager.getConnection("jdbc:hsqldb:TestDB", "sa", "");
			PreparedStatement pstmt = connection.prepareStatement("INSERT INTO people (fullname, profile, status, gender, age, state) "
					+ "values (?,?,?,?,?,?)") ;
			pstmt.setString(1, "Alex Smith");
			pstmt.setString(2, "");
			pstmt.setString(3, "student at Rmit");
			pstmt.setString(4,"M");
			pstmt.setInt(5, 21);
			pstmt.setString(6, "VIC");
			pstmt.execute();
			result++;
			
			//query from the db
			rs = connection.prepareStatement("select * from people;").executeQuery();
			
			while (rs.next()) {
				System.out.println((rs.getString("fullname") + "|" +
									rs.getString("profile") + "|" +
									rs.getString("status") + "|" +
									rs.getString("gender") + "|" +
									rs.getInt("age") + "|" + 
									rs.getString("state")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println(result + " rows effected");
	}
	
	public static void DBUpdateProfile() throws Exception {
		
		int result = 0;
		ResultSet rs = null;
		//Registering the HSQLDB JDBC driver
		Class.forName("org.hsqldb.jdbcDriver");
		//Creating the connection with HSQLDB
		connection = DriverManager.getConnection("jdbc:hsqldb:TestDB", "sa", "");
		
		try {
			PreparedStatement pstmt = connection.prepareStatement("UPDATE people SET profile = ? WHERE fullname = ?");
			pstmt.setString(1, "me.jpg");
			pstmt.setString(2, "Alex Smith");
			pstmt.execute();
			result++;
			
		}catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println(result + " rows effected");
		
		rs = connection.prepareStatement("select * from people;").executeQuery();
		
		while (rs.next()) {
			System.out.println((rs.getString("fullname") + "|" +
								rs.getString("profile") + "|" +
								rs.getString("status") + "|" +
								rs.getString("gender") + "|" +
								rs.getInt("age") + "|" + 
								rs.getString("state")));
			result++;
		}
	}
	
	public static void DBDelete() throws Exception {
		int result = 0;
		ResultSet rs = null;
		//Registering the HSQLDB JDBC driver
		Class.forName("org.hsqldb.jdbcDriver");
		//Creating the connection with HSQLDB
		connection = DriverManager.getConnection("jdbc:hsqldb:TestDB", "sa", "");
		
		try {
			PreparedStatement pstmt = connection.prepareStatement("DELETE FROM people WHERE fullname = ?");
			pstmt.setString(1, "Alex Smith");
			pstmt.execute();
			result++;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(result + " rows effected");
		
		rs = connection.prepareStatement("select * from people;").executeQuery();
		
		while (rs.next()) {
			System.out.println((rs.getString("fullname") + "|" +
								rs.getString("profile") + "|" +
								rs.getString("status") + "|" +
								rs.getString("gender") + "|" +
								rs.getInt("age") + "|" + 
								rs.getString("state")));
		}
	}

}
