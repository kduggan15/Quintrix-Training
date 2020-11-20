package MySqlWork;

import org.testng.annotations.Test;

import TheInternet.foundation.ConfigurationReader;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SqlHw {
	private String url;
	String user;
	String password;
	public SqlHw() {
		HashMap<String,String> configs = null;
		try {
			configs = new ConfigurationReader().getPropertiesFromResourceFile("config.properties");
		} catch (IOException e) {
			//e.printStackTrace();
			throw new RuntimeException(e+"Config file does not exist");
		}

		this.url = "jdbc:mysql://localhost:3306/sakila?allowPublicKeyRetrieval=true&useSSL=false";
		this.user = "root";
		this.password = configs.get("dbpass");
	}
	@Test
	public void Problem2() {
		
		String query = "SELECT title FROM film WHERE title LIKE '%airplane%'";
		try {
			Connection con = DriverManager.getConnection(url, user, this.password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				System.out.println(rs.getString(1));
				Assert.assertTrue(rs.getString(1).contains("AIRPLANE"));
			}

		} catch (SQLException ex) {
			System.out.println(ex);
		} 

	}
	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
